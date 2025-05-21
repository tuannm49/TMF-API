package oda.api.tmf.codegen;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.parser.OpenAPIV3Parser;

import java.util.HashSet;
import java.util.Set;

public class OpenAPISchemaExtractor {
    public static void main(String[] args) {
        // Đường dẫn đến tệp OpenAPI YAML
        String filePath = "/Volumes/Data/work/ERP/ODA/Code/TMF-API/TMF_CODE_GEN/openApiTest/TMF620-Product_Catalog_Management-v5.0.0.oas.yaml";
//        String filePath = "/Volumes/Data/work/ERP/ODA/Code/TMF-API/TMF_CODE_GEN/openApiTest/TMF723_Policy_v4.yaml";
        // Khởi tạo parser
        OpenAPIV3Parser parser = new OpenAPIV3Parser();
        OpenAPI openAPI = parser.read(filePath);

        if (openAPI == null) {
            System.out.println("Không thể phân tích tệp OpenAPI. Vui lòng kiểm tra tệp.");
            return;
        }
        Set<String> schemaSet = checkOperationSchemas(openAPI);
        System.out.println("\nDanh sách các schema được sử dụng trong response:");
        schemaSet.forEach(schema -> System.out.println("- " + schema));
        System.out.println("Tổng số schema: " + schemaSet.size());
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
}