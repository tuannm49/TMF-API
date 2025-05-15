package com.example.codegen;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DirectoryScanner {
    public static void main(String[] args) {
        // Thay đổi đường dẫn thư mục tại đây
        String directoryPath = "/Volumes/Data/work/ERP/ODA/Code/TMF-API/schemas-candidates"; // Ví dụ: "C:/Users/YourName/Documents"
        String outputJsonPath = "TMF_CODE_GEN/directory_structure.json";

        try {
            // Tạo cấu trúc dữ liệu
            Map<String, String[]> directoryMap = new HashMap<>();
            File rootDir = new File(directoryPath);

            // Kiểm tra thư mục tồn tại
            if (!rootDir.exists() || !rootDir.isDirectory()) {
                System.out.println("Thư mục không tồn tại hoặc không phải là thư mục!");
                return;
            }

            // Lấy danh sách thư mục con
            File[] subDirs = rootDir.listFiles(File::isDirectory);
            if (subDirs != null) {
                for (File subDir : subDirs) {
                    // Lấy danh sách file con trực tiếp trong thư mục
                    File[] files = subDir.listFiles(File::isFile);
                    String[] fileNames = files != null ?
                            new String[files.length] : new String[0];
                    for (int i = 0; i < fileNames.length; i++) {
                        // Xử lý tên file: loại bỏ ".schema.json"
                        String fileName = files[i].getName();
                        if (fileName.endsWith(".schema.json")) {
                            fileNames[i] = fileName.replace(".schema.json", "");
                        } else {
                            fileNames[i] = fileName;
                        }
                    }
                    directoryMap.put(subDir.getName(), fileNames);
                }
            }

            // Ghi dữ liệu vào file JSON
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(outputJsonPath), directoryMap);

            System.out.println("Đã tạo file JSON tại: " + outputJsonPath);

        } catch (IOException e) {
            System.err.println("Lỗi khi xử lý: " + e.getMessage());
        }
    }
}