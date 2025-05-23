package oda.api.tmf.codegen;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CodeGenerator {
    private final String outputDirDefault = "oda/sid/tmf/model/others/";
    private final String packageNameDefault = "oda.sid.tmf.model.others";
    private final String directoryMapFile = "TMF_CODE_GEN/directory_structure.json";
    private final String directoryPath = "TMF_CODE_GEN/openApiTest";
    private final String configFile = "TMF_CODE_GEN/config.json";
    private static Map<String, String[]> configMap,directoryMap = new HashMap<>();
    public CodeGenerator() {
    }

    public void generate() throws IOException {
        // Đọc file JSON cấu hình
        ObjectMapper mapper = new ObjectMapper();
        directoryMap = mapper.readValue(
                new File(directoryMapFile),
                mapper.getTypeFactory().constructMapType(Map.class, String.class, String[].class)
        );
        configMap = mapper.readValue(
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
            openAPI.getComponents().getSchemas().forEach((schemaName,Schema)->{
                String category = findCategoryByFileName(schemaName);
                if(schemaName.equals("ExternalIdentifier")){
                    System.out.println("");
                }
                if(!isExítConfig("ignoreSchema",schemaName)){
                    if(category!=null){
                        String outputDir = apiDirGen+"/"+category.replace(".","/");
                        String packageName = category;
                        String fileName = toCamelCase(schemaName, true) + ".java";
                        try {
                            Files.createDirectories(Paths.get(outputDir));
                            schemaProcessor.processSchema(schemaName, fileName, outputDir, packageName);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        String fileName = toCamelCase(schemaName, true) + ".java";
                        try {
                            Files.createDirectories(Paths.get(apiDirGen+"/"+outputDirDefault));
                            schemaProcessor.processSchema(schemaName, fileName, apiDirGen+"/"+outputDirDefault, packageNameDefault);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }
            });

        }


    }
    private static Set<String> checkOperationSchemas(OpenAPI openAPI ) {
        Set<String> schemaSet = new HashSet<>();
        openAPI.getPaths().forEach((path, pathItem) -> {
            Operation operation = pathItem.getPatch();
            if (operation != null) {
                ApiResponses responses = operation.getResponses();
                if (responses != null) {
                    responses.forEach((status, response) -> {
                        Content content = response.getContent();
                        if (content != null) {
                            MediaType mediaType = content.get("application/json");
                            if (mediaType != null && mediaType.getSchema() != null) {
                                String schemaRef = mediaType.getSchema().get$ref();
                                if (schemaRef != null) {
                                    String schemaName = schemaRef.replace("#/components/schemas/", "");
                                    if(!"Error".equals(schemaName))
                                        schemaSet.add(schemaName);
                                }
                            }
                        }
                    });
                }
            }

        });
        return schemaSet;

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
    public static boolean isExítConfig(String configName, String name) {
        String[] ignoreSchema = configMap.get(configName);
        for (String file : ignoreSchema) {
            String regex = file.replace("*", ".*");
            // Kiểm tra xem fileName khớp với regex
            if (name.matches(regex)) {
                return true;
            }
        }
        return false;
    }
    public static String findCategoryByFileName(String fileName) {
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
        if("Entity".equals(name)) return "AbstractEntity";
        if("EntityRef".equals(name)) return "AbstractEntityRef";
        return name;
    }

    public static void main(String[] args) throws IOException {
        CodeGenerator generator = new CodeGenerator();
        generator.generate();
        System.out.println("Code generation completed!");
    }
}
