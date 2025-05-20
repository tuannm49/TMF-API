package oda.api.tmf.codegen;

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
    private final String outputDirDefault = "oda/sid/tmf/model/others/";
    private final String packageNameDefault = "oda.sid.tmf.model.others";
    private final String directoryMapFile = "TMF_CODE_GEN/directory_structure.json";
    private final String directoryPath = "TMF_CODE_GEN/openApiTest";
    private final String configFile = "TMF_CODE_GEN/config.json";
    public CodeGenerator() {
    }

    public void generate() throws IOException {
        // Đọc file JSON cấu hình
        ObjectMapper mapper = new ObjectMapper();
//        List<Map<String, Object>> config = mapper.readValue(new File(configFile), new TypeReference<>() {});
        Map<String, String[]> directoryMap = mapper.readValue(
                new File(directoryMapFile),
                mapper.getTypeFactory().constructMapType(Map.class, String.class, String[].class)
        );
        Map<String, String[]> configMap = mapper.readValue(
                new File(configFile),
                mapper.getTypeFactory().constructMapType(Map.class, String.class, String[].class)
        );
        // Đọc file OpenAPI
        ParseOptions options = new ParseOptions();
        options.setResolve(true);
        List<String> lstFile = getFilesInDirectory(directoryPath);

        for(String openApiFile: lstFile){
            String apiDirGen =  "GenCode/"+openApiFile.replace(".yaml","");
            OpenAPI openAPI = new OpenAPIV3Parser().read(directoryPath+"/"+openApiFile, null, options);
            // Sinh entity classes
            SchemaProcessor schemaProcessor = new SchemaProcessor(openAPI,apiDirGen,directoryMap,configMap);
            Map<String,Schema> lstSch = openAPI.getComponents().getSchemas();
            for (Map.Entry<String, Schema> schemaEntry : lstSch.entrySet()) {
                String category = findCategoryByFileName(directoryMap,schemaEntry.getKey());
                if(!findIgnoreByFileName(configMap,schemaEntry.getKey())){
                    if(category!=null){
                        String schemaName = schemaEntry.getKey();
                        String outputDir = apiDirGen+"/"+category.replace(".","/");
                        String packageName = category;
                        String fileName = toCamelCase(schemaName, true) + ".java";
                        Files.createDirectories(Paths.get(outputDir));
                        schemaProcessor.processSchema(schemaName, fileName, outputDir, packageName);
                    }else {
                        String schemaName = schemaEntry.getKey();
                        String fileName = toCamelCase(schemaName, true) + ".java";
                        Files.createDirectories(Paths.get(apiDirGen+"/"+outputDirDefault));
                        schemaProcessor.processSchema(schemaName, fileName, apiDirGen+"/"+outputDirDefault, packageNameDefault);
                    }
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
    public static boolean findIgnoreByFileName(Map<String, String[]> ignoreMap, String fileName) {
        String[] ignoreSchema = ignoreMap.get("ignoreSchema");
        for (String file : ignoreSchema) {
            String regex = file.replace("*", ".*");
            // Kiểm tra xem fileName khớp với regex
            if (fileName.matches(regex)) {
                return true;
            }
        }
        return false;
    }
    public static String findCategoryByFileName(Map<String, String[]> directoryMap, String fileName) {
        // Duyệt qua từng danh mục trong Map
        for (Map.Entry<String, String[]> entry : directoryMap.entrySet()) {
            String category = entry.getKey();
            String[] files = entry.getValue();

            // Chuyển pattern thành regex: thay * bằng .*

            // Kiểm tra xem fileName có trong danh sách files không
            for (String file : files) {
                String regex = file.replace("*", ".*");
                // Kiểm tra xem fileName khớp với regex
                if (fileName.matches(regex)) {
                    return category;
                }
//                if (file.equals(fileName)) {
//                    return category;
//                }
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
        if("Entity".equals(name)) return "BaseEntity";
        if("EntityRef".equals(name)) return "BaseEntityRef";
        return name;
    }

    public static void main(String[] args) throws IOException {
        CodeGenerator generator = new CodeGenerator();
        generator.generate();
        System.out.println("Code generation completed!");
    }
}
