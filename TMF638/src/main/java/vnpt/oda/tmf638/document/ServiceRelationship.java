package vnpt.oda.tmf638.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "service_relationship")
public class ServiceRelationship {
    @Id
    private String id;

    private String serviceId;
    private String relatedServiceId;
    private String relationshipType;
    private String baseType;
    private String schemaLocation;
    private String type;
}

