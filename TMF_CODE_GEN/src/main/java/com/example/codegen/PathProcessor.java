package com.example.codegen;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class PathProcessor {
    private final OpenAPI openAPI;
    private final String outputDir;
    private final String basePackage;
    public PathProcessor(OpenAPI openAPI, String outputDir, String basePackage) {
        this.openAPI = openAPI;
        this.outputDir = outputDir;
        this.basePackage = basePackage;
    }

    public void processPaths() throws IOException {
        Paths paths = openAPI.getPaths();
        for (Map.Entry<String, PathItem> pathEntry : paths.entrySet()) {
            String path = pathEntry.getKey();
            PathItem pathItem = pathEntry.getValue();
            if (path.startsWith("/policyRule")) {
                generateControllerClass("PolicyRule", pathItem);
            }
            // Có thể thêm các resource khác như policyEvent, policyCondition, v.v.
        }
    }

    private void generateControllerClass(String resourceName, PathItem pathItem) throws IOException {
        String className = resourceName + "Controller";
        String entityName = resourceName;
        StringBuilder sb = new StringBuilder();

        // Package và imports
        sb.append("package ").append(basePackage).append(".controller;\n\n");
        sb.append("import ").append(basePackage).append(".entity.").append(entityName).append(";\n");
        sb.append("import ").append(basePackage).append(".entity.Error;\n");
        sb.append("import org.springframework.http.HttpHeaders;\n");
        sb.append("import org.springframework.http.HttpStatus;\n");
        sb.append("import org.springframework.http.ResponseEntity;\n");
        sb.append("import org.springframework.web.bind.annotation.*;\n");
        sb.append("import java.util.ArrayList;\n");
        sb.append("import java.util.List;\n");
        sb.append("import java.util.Optional;\n\n");

        // Class
        sb.append("@RestController\n");
        sb.append("@RequestMapping(\"/tmf-api/policy/v4/").append(toLowerCamelCase(resourceName)).append("\")\n");
        sb.append("public class ").append(className).append(" {\n\n");

        // Giả lập dữ liệu
        sb.append("    private final List<").append(entityName).append("> ").append(toLowerCamelCase(resourceName)).append("s = new ArrayList<>();\n\n");

        // GET List
        if (pathItem.getGet() != null) {
            sb.append("    @GetMapping\n");
            sb.append("    public ResponseEntity<List<").append(entityName).append(">> list").append(resourceName).append("s(\n");
            sb.append("            @RequestParam(required = false) String fields,\n");
            sb.append("            @RequestParam(required = false) Integer offset,\n");
            sb.append("            @RequestParam(required = false) Integer limit) {\n");
            sb.append("        HttpHeaders headers = new HttpHeaders();\n");
            sb.append("        headers.add(\"X-Total-Count\", String.valueOf(").append(toLowerCamelCase(resourceName)).append("s.size()));\n");
            sb.append("        headers.add(\"X-Result-Count\", String.valueOf(").append(toLowerCamelCase(resourceName)).append("s.size()));\n");
            sb.append("        List<").append(entityName).append("> result = ").append(toLowerCamelCase(resourceName)).append("s;\n");
            sb.append("        if (offset != null && limit != null) {\n");
            sb.append("            int start = Math.min(offset, ").append(toLowerCamelCase(resourceName)).append("s.size());\n");
            sb.append("            int end = Math.min(offset + limit, ").append(toLowerCamelCase(resourceName)).append("s.size());\n");
            sb.append("            result = ").append(toLowerCamelCase(resourceName)).append("s.subList(start, end);\n");
            sb.append("        }\n");
            sb.append("        return new ResponseEntity<>(result, headers, HttpStatus.OK);\n");
            sb.append("    }\n\n");
        }

        // POST
        if (pathItem.getPost() != null) {
            sb.append("    @PostMapping\n");
            sb.append("    public ResponseEntity<").append(entityName).append("> create").append(resourceName).append("(@RequestBody ").append(entityName).append(" ").append(toLowerCamelCase(resourceName)).append(") {\n");
            sb.append("        if (").append(toLowerCamelCase(resourceName)).append(".getId() == null) {\n");
            sb.append("            ").append(toLowerCamelCase(resourceName)).append(".setId(String.valueOf(").append(toLowerCamelCase(resourceName)).append("s.size() + 1));\n");
            sb.append("        }\n");
            sb.append("        ").append(toLowerCamelCase(resourceName)).append("s.add(").append(toLowerCamelCase(resourceName)).append(");\n");
            sb.append("        return new ResponseEntity<>(").append(toLowerCamelCase(resourceName)).append(", HttpStatus.CREATED);\n");
            sb.append("    }\n\n");
        }

        // GET by ID, PATCH, DELETE (cho path /resource/{id})
        if (pathItem.getGet() != null || pathItem.getPatch() != null || pathItem.getDelete() != null) {
            if (pathItem.getGet() != null) {
                sb.append("    @GetMapping(\"/{id}\")\n");
                sb.append("    public ResponseEntity<?> retrieve").append(resourceName).append("(@PathVariable String id, @RequestParam(required = false) String fields) {\n");
                sb.append("        Optional<").append(entityName).append("> ").append(toLowerCamelCase(resourceName)).append(" = ").append(toLowerCamelCase(resourceName)).append("s.stream()\n");
                sb.append("                .filter(pr -> pr.getId().equals(id))\n");
                sb.append("                .findFirst();\n");
                sb.append("        if (").append(toLowerCamelCase(resourceName)).append(".isPresent()) {\n");
                sb.append("            return new ResponseEntity<>(").append(toLowerCamelCase(resourceName)).append(".get(), HttpStatus.OK);\n");
                sb.append("        } else {\n");
                sb.append("            Error error = new Error();\n");
                sb.append("            error.setCode(\"404\");\n");
                sb.append("            error.setReason(\"Not Found\");\n");
                sb.append("            error.setMessage(\"").append(resourceName).append(" with id \" + id + \" not found\");\n");
                sb.append("            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);\n");
                sb.append("        }\n");
                sb.append("    }\n\n");
            }

            if (pathItem.getPatch() != null) {
                sb.append("    @PatchMapping(\"/{id}\")\n");
                sb.append("    public ResponseEntity<?> patch").append(resourceName).append("(@PathVariable String id, @RequestBody ").append(entityName).append(" ").append(toLowerCamelCase(resourceName)).append(") {\n");
                sb.append("        Optional<").append(entityName).append("> existing = ").append(toLowerCamelCase(resourceName)).append("s.stream()\n");
                sb.append("                .filter(pr -> pr.getId().equals(id))\n");
                sb.append("                .findFirst();\n");
                sb.append("        if (existing.isPresent()) {\n");
                sb.append("            ").append(entityName).append(" updated = existing.get();\n");
                sb.append("            if (").append(toLowerCamelCase(resourceName)).append(".getDescription() != null) updated.setDescription(").append(toLowerCamelCase(resourceName)).append(".getDescription());\n");
                sb.append("            if (").append(toLowerCamelCase(resourceName)).append(".getName() != null) updated.setName(").append(toLowerCamelCase(resourceName)).append(".getName());\n");
                sb.append("            return new ResponseEntity<>(updated, HttpStatus.OK);\n");
                sb.append("        } else {\n");
                sb.append("            Error error = new Error();\n");
                sb.append("            error.setCode(\"404\");\n");
                sb.append("            error.setReason(\"Not Found\");\n");
                sb.append("            error.setMessage(\"").append(resourceName).append(" with id \" + id + \" not found\");\n");
                sb.append("            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);\n");
                sb.append("        }\n");
                sb.append("    }\n\n");
            }

            if (pathItem.getDelete() != null) {
                sb.append("    @DeleteMapping(\"/{id}\")\n");
                sb.append("    public ResponseEntity<Void> delete").append(resourceName).append("(@PathVariable String id) {\n");
                sb.append("        boolean removed = ").append(toLowerCamelCase(resourceName)).append("s.removeIf(pr -> pr.getId().equals(id));\n");
                sb.append("        if (removed) {\n");
                sb.append("            return new ResponseEntity<>(HttpStatus.NO_CONTENT);\n");
                sb.append("        } else {\n");
                sb.append("            Error error = new Error();\n");
                sb.append("            error.setCode(\"404\");\n");
                sb.append("            error.setReason(\"Not Found\");\n");
                sb.append("            error.setMessage(\"").append(resourceName).append(" with id \" + id + \" not found\");\n");
                sb.append("            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);\n");
                sb.append("        }\n");
                sb.append("    }\n");
            }
        }

        sb.append("}\n");

        // Ghi file
        String filePath = java.nio.file.Paths.get(outputDir, "controller", className + ".java").toString();
        Files.writeString(java.nio.file.Paths.get(filePath), sb.toString());
    }

    private String toLowerCamelCase(String name) {
        String camelCase = toCamelCase(name, true);
        return Character.toLowerCase(camelCase.charAt(0)) + camelCase.substring(1);
    }

    private String toCamelCase(String name, boolean capitalizeFirst) {
        String[] parts = name.split("[_-]");
        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            result.append(Character.toUpperCase(part.charAt(0)))
                    .append(part.substring(1).toLowerCase());
        }
        if (!capitalizeFirst) {
            result.setCharAt(0, Character.toLowerCase(result.charAt(0)));
        }
        return result.toString();
    }
}
