package vnpt.oda.tmf638.dto;


import lombok.Data;

@Data
public class ServiceRelationshipDTO {
    private String id;
    private String relatedServiceId;
    private String relationshipType;
    private String baseType;
    private String schemaLocation;
    private String type;
}

