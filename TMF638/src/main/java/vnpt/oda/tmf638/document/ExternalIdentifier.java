package vnpt.oda.tmf638.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "external_identifier")
public class ExternalIdentifier {
    @Id
    private String id;

    private String serviceId;
    private String externalIdentifierType;
    private String owner;
    private String baseType;
    private String schemaLocation;
    private String type;
}
