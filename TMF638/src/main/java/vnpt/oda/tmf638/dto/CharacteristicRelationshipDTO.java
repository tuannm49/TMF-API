package vnpt.oda.tmf638.dto;

import lombok.Data;

@Data
public class CharacteristicRelationshipDTO {
    private String id;
    private String characteristicId;
    private String relatedCharacteristicId;
    private String relationshipType;
    private String baseType;
    private String schemaLocation;
    private String type;
}

