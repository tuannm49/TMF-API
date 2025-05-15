package com.example.codegen;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CodeGenerator {
    private final String outputDirDefault = "tmf/model/trash/";
    private final String packageNameDefault = "com.example.trash";
    private final String configFile;
    private final String directoryPath = "TMF_CODE_GEN/openApi";
    public CodeGenerator(String configFile) {
        this.configFile = configFile;
    }

    public void generate() throws IOException {
        // Đọc file JSON cấu hình
        ObjectMapper mapper = new ObjectMapper();
//        List<Map<String, Object>> config = mapper.readValue(new File(configFile), new TypeReference<>() {});
        Map<String, String[]> directoryMap = mapper.readValue(
                new File(configFile),
                mapper.getTypeFactory().constructMapType(Map.class, String.class, String[].class)
        );
        // Đọc file OpenAPI
        ParseOptions options = new ParseOptions();
        options.setResolve(true);
        List<String> lstFile = getFilesInDirectory(directoryPath);

        for(String openApiFile: lstFile){
            OpenAPI openAPI = new OpenAPIV3Parser().read(directoryPath+"/"+openApiFile, null, options);
            // Sinh entity classes
            SchemaProcessor schemaProcessor = new SchemaProcessor(openAPI);
            Map<String,Schema> lstSch = openAPI.getComponents().getSchemas();
            for (Map.Entry<String, Schema> schemaEntry : lstSch.entrySet()) {
                String category = findCategoryByFileName(directoryMap,schemaEntry.getKey());
                if(category!=null){
                    String schemaName = schemaEntry.getKey();
                    String outputDir = outputDirDefault.replace("trash",category);
                    String packageName = packageNameDefault.replace("trash",category);
                    String fileName = toCamelCase(schemaName, true) + ".java";
                    Files.createDirectories(Paths.get(outputDir));
                    schemaProcessor.processSchema(schemaName, fileName, outputDir, packageName);
                }else {
                    String schemaName = schemaEntry.getKey();
                    String fileName = toCamelCase(schemaName, true) + ".java";
                    Files.createDirectories(Paths.get(outputDirDefault));
                    schemaProcessor.processSchema(schemaName, fileName, outputDirDefault, packageNameDefault);
                }
            }
        }

    }
    public static List<String> getFilesInDirectory(String directoryPath) {
        List<String> fileNames = new ArrayList<>();
        try {
            File directory = new File(directoryPath);

            // Kiểm tra thư mục tồn tại và là thư mục
            if (!directory.exists() || !directory.isDirectory()) {
                System.out.println("Thư mục không tồn tại hoặc không phải là thư mục!");
                return fileNames;
            }

            // Lấy danh sách file trực tiếp trong thư mục
            File[] files = directory.listFiles(File::isFile);
            if (files != null) {
                for (File file : files) {
                    fileNames.add(file.getName());
                }
            }

        } catch (Exception e) {
            System.err.println("Lỗi khi truy cập thư mục: " + e.getMessage());
        }
        return fileNames;
    }
    public static String findCategoryByFileName(Map<String, String[]> directoryMap, String fileName) {
        // Duyệt qua từng danh mục trong Map
        for (Map.Entry<String, String[]> entry : directoryMap.entrySet()) {
            String category = entry.getKey();
            String[] files = entry.getValue();

            // Kiểm tra xem fileName có trong danh sách files không
            for (String file : files) {
                if (file.equals(fileName)) {
                    return category;
                }
            }
        }

        // Trả về null nếu không tìm thấy
        return null;
    }
    private Map<String, String> getOutputDirDefault(List<Map<String, String>> entities,String entityName){
        for (Map<String, String> entity : entities) {
            if(entityName.equals(entity.get("schemaName"))){
                return entity;
            }
        }
        return null;
    }
    private String toCamelCase(String name, boolean capitalizeFirst) {
        return name;
        /*
        String[] parts = name.split("[_-]");
        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            result.append(Character.toUpperCase(part.charAt(0)))
                    .append(part.substring(1).toLowerCase());
        }
        if (!capitalizeFirst) {
            result.setCharAt(0, Character.toLowerCase(result.charAt(0)));
        }
        return result.toString();*/
    }

    public static void main(String[] args) throws IOException {
        String configFile = "TMF_CODE_GEN/directory_structure.json";
        CodeGenerator generator = new CodeGenerator(configFile);
        generator.generate();
        System.out.println("Code generation completed!");
    }
}
