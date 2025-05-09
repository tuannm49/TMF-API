package vnpt.oda.tmf638.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "supporting_resource")
public class SupportingResource {
    @Id
    private String id;

    private String serviceId;
    private String resourceId;
    private String href;
    private String referredType;
    private String baseType;
    private String schemaLocation;
    private String type;
}

