package oda.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;

// Lớp Task
class Task {
    private final String taskId;
    private final Supplier<String> action;
    private final Supplier<List<Task>> subtaskSupplier;
    private volatile String status;
    private String result;
    private String error;
    private final int priority;
    private final int maxRetries;
    private int retryCount;

    public Task(String taskId, Supplier<String> action, Supplier<List<Task>> subtaskSupplier, int priority, int maxRetries) {
        this.taskId = taskId;
        this.action = action;
        this.subtaskSupplier = subtaskSupplier != null ? subtaskSupplier : () -> new ArrayList<>();
        this.status = "PENDING";
        this.priority = Math.max(1, Math.min(10, priority));
        this.maxRetries = maxRetries;
        this.retryCount = 0;
    }

    public String getTaskId() { return taskId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
    public List<Task> getSubtasks() { return subtaskSupplier.get(); }
    public int getPriority() { return priority; }
    public int getMaxRetries() { return maxRetries; }
    public int getRetryCount() { return retryCount; }
    public void incrementRetryCount() { this.retryCount++; }
}

// Record TaskResult (Java 21)
record TaskResult(String taskId, String status, String result, String error) {
    @Override
    public String toString() {
        return switch (status) {
            case "SUCCESS" -> "Task %s: %s%nResult: %s".formatted(taskId, status, result);
            case "CANCELLED" -> "Task %s: %s%nCancelled".formatted(taskId, status);
            default -> "Task %s: %s%nError: %s".formatted(taskId, status, error);
        };
    }
}

// Engine orchestration với virtual threads
public class OrchestrationEngine {
    private final ExecutorService executor;
    private final PriorityBlockingQueue<Runnable> taskQueue;
    private final ConcurrentLinkedQueue<TaskResult> resultQueue;
    private final Map<String, CompletableFuture<Void>> taskFutures;
    private final Logger logger;
    private final long timeoutSeconds;

    public OrchestrationEngine(long timeoutSeconds) {
        // Sử dụng virtual threads
        this.executor = Executors.newVirtualThreadPerTaskExecutor();
        this.taskQueue = new PriorityBlockingQueue<>(10, (r1, r2) -> {
            if (r1 instanceof TaskWrapper tw1 && r2 instanceof TaskWrapper tw2) {
                return tw2.getTask().getPriority() - tw1.getTask().getPriority();
            }
            return 0;
        });
        this.resultQueue = new ConcurrentLinkedQueue<>();
        this.taskFutures = new ConcurrentHashMap<>();
        this.logger = Logger.getLogger(OrchestrationEngine.class.getName());
        this.timeoutSeconds = timeoutSeconds;
    }

    private record TaskWrapper(Task task, OrchestrationEngine engine) implements Runnable {
        @Override
        public void run() {
            engine.processTask(task);
        }
    }

    public void registerTask(Task task) {
        logger.info("Registered task: %s with priority: %d".formatted(task.getTaskId(), task.getPriority()));
    }

    private void processTask(Task task) {
        long startTime = System.currentTimeMillis();
        logger.info("Starting task: %s".formatted(task.getTaskId()));

        try {
            task.setStatus("RUNNING");

            CompletableFuture<String> actionFuture = CompletableFuture.supplyAsync(task.action, executor);
            String result = actionFuture.orTimeout(timeoutSeconds, TimeUnit.SECONDS).get();
            task.setResult(result);

            List<Task> subtasks = task.getSubtasks();
            subtasks.forEach(this::registerTask);

            List<CompletableFuture<Void>> subtaskFutures = new ArrayList<>();
            for (Task subtask : subtasks) {
                CompletableFuture<Void> subtaskFuture = CompletableFuture.runAsync(
                        new TaskWrapper(subtask, this), executor);
                taskFutures.put(subtask.getTaskId(), subtaskFuture);
                subtaskFutures.add(subtaskFuture);
            }

            CompletableFuture.allOf(subtaskFutures.toArray(new CompletableFuture[0])).join();

            boolean allSubtasksSuccess = subtasks.stream().allMatch(subtask -> "COMPLETED".equals(subtask.getStatus()));

            if (allSubtasksSuccess) {
                task.setStatus("COMPLETED");
                resultQueue.add(new TaskResult(task.getTaskId(), "SUCCESS", task.getResult(), null));
                logger.info("Task %s completed successfully in %dms"
                        .formatted(task.getTaskId(), System.currentTimeMillis() - startTime));
            } else {
                task.setStatus("FAILED");
                resultQueue.add(new TaskResult(task.getTaskId(), "FAILED", null, "One or more subtasks failed"));
                logger.warning("Task %s failed due to subtask failure".formatted(task.getTaskId()));
            }
        } catch (Exception e) {
            if (e instanceof CancellationException) {
                task.setStatus("CANCELLED");
                resultQueue.add(new TaskResult(task.getTaskId(), "CANCELLED", null, "Task was cancelled"));
                logger.info("Task %s was cancelled".formatted(task.getTaskId()));
            } else {
                task.incrementRetryCount();
                if (task.getRetryCount() < task.getMaxRetries()) {
                    logger.warning("Retrying task %s (Attempt %d/%d)"
                            .formatted(task.getTaskId(), task.getRetryCount() + 1, task.getMaxRetries()));
                    CompletableFuture<Void> retryFuture = CompletableFuture.runAsync(
                            new TaskWrapper(task, this), executor);
                    taskFutures.put(task.getTaskId(), retryFuture);
                    return;
                } else {
                    task.setStatus("FAILED");
                    task.setError(e.getMessage());
                    resultQueue.add(new TaskResult(task.getTaskId(), "FAILED", null, e.getMessage()));
                    logger.severe("Task %s failed after %d retries: %s"
                            .formatted(task.getTaskId(), task.getMaxRetries(), e.getMessage()));
                }
            }
        } finally {
            taskFutures.remove(task.getTaskId());
        }
    }

    public CompletableFuture<Void> execute(Task rootTask) {
        registerTask(rootTask);
        CompletableFuture<Void> future = CompletableFuture.runAsync(
                new TaskWrapper(rootTask, this), executor);
        taskFutures.put(rootTask.getTaskId(), future);
        return future;
    }

    public boolean cancelTask(String taskId) {
        CompletableFuture<Void> future = taskFutures.get(taskId);
        if (future == null) {
            logger.warning("Cannot cancel task %s: Task not found or already completed".formatted(taskId));
            return false;
        }

        boolean cancelled = future.cancel(true);
        if (cancelled) {
            logger.info("Cancelled task: %s".formatted(taskId));
            taskFutures.keySet().stream()
                    .filter(id -> id.startsWith(taskId + "_") || taskFutures.get(id).equals(future))
                    .forEach(subTaskId -> {
                        CompletableFuture<Void> subFuture = taskFutures.get(subTaskId);
                        if (subFuture != null) {
                            subFuture.cancel(true);
                            logger.info("Cancelled subtask: %s".formatted(subTaskId));
                        }
                    });
        }
        return cancelled;
    }

    public List<TaskResult> getResults() {
        List<TaskResult> results = new ArrayList<>();
        while (!resultQueue.isEmpty()) {
            results.add(resultQueue.poll());
        }
        return results;
    }

    public void shutdown() {
        executor.close(); // Java 21: AutoCloseable ExecutorService
        logger.info("Orchestration engine shutdown");
    }
}

// Lớp sinh cây task
class TaskTreeGenerator {
    private static final Random random = new Random();

    public static Task generateTaskTree(int depth, int maxSubtasks, String parentId) {
        if (depth <= 0) return null;

        String taskId = parentId + "_" + UUID.randomUUID().toString().substring(0, 8);
        int priority = random.nextInt(10) + 1;
        int maxRetries = 2;

        Supplier<List<Task>> subtaskSupplier = () -> {
            List<Task> subtasks = new ArrayList<>();
            int numSubtasks = random.nextInt(maxSubtasks + 1);
            for (int i = 0; i < numSubtasks && depth > 1; i++) {
                Task subtask = generateTaskTree(depth - 1, maxSubtasks, taskId);
                if (subtask != null) subtasks.add(subtask);
            }
            return subtasks;
        };

        return new Task(taskId, () -> sampleAction(taskId), subtaskSupplier, priority, maxRetries);
    }

    private static String sampleAction(String taskName) {
        try {
            Thread.sleep(500);
            if (random.nextDouble() < 0.1) {
                throw new RuntimeException("Random failure in " + taskName);
            }
            return "Result of " + taskName;
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted: " + taskName);
        }
    }
}

// Kiểm tra với cây 10 cấp
public class Main {
    public static void main(String[] args) throws Exception {
        OrchestrationEngine engine = new OrchestrationEngine(2);
        long startTime = System.currentTimeMillis();

        Task rootTask = TaskTreeGenerator.generateTaskTree(10, 3, "root");
        int totalTasks = countTasks(rootTask);
        System.out.println("Total tasks in tree: " + totalTasks);

        CompletableFuture<Void> execution = engine.execute(rootTask);

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                Task level5Task = findTaskAtLevel(rootTask, 5);
                if (level5Task != null) {
                    System.out.println("Attempting to cancel task at level 5: " + level5Task.getTaskId());
                    engine.cancelTask(level5Task.getTaskId());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        execution.get();

        List<TaskResult> results = engine.getResults();
        System.out.println("\nResults (" + results.size() + " tasks):");
        for (TaskResult result : results) {
            System.out.println(result);
        }

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Total execution time: " + duration + "ms");

        engine.shutdown();
    }

    private static int countTasks(Task task) {
        if (task == null) return 0;
        int count = 1;
        for (Task subtask : task.getSubtasks()) {
            count += countTasks(subtask);
        }
        return count;
    }

    private static Task findTaskAtLevel(Task task, int targetLevel) {
        if (task == null) return null;
        if (targetLevel == 1) return task;
        for (Task subtask : task.getSubtasks()) {
            Task found = findTaskAtLevel(subtask, targetLevel - 1);
            if (found != null) return found;
        }
        return null;
    }
}
