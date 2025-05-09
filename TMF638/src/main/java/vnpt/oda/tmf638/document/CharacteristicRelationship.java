package vnpt.oda.tmf638.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "characteristic_relationship")
public class CharacteristicRelationship {
    @Id
    private String id;

    private String characteristicId;
    private String relatedCharacteristicId;
    private String relationshipType;
    private String baseType;
    private String schemaLocation;
    private String type;
}

