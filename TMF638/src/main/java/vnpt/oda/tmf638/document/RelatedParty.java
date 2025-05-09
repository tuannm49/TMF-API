package vnpt.oda.tmf638.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "related_party")
public class RelatedParty {
    @Id
    private String id;

    private String serviceId;
    private String partyId;
    private String role;
    private String href;
    private String name;
    private String referredType;
    private String baseType;
    private String schemaLocation;
    private String type;
}
