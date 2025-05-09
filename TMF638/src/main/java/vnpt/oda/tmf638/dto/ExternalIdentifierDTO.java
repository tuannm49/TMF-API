package vnpt.oda.tmf638.dto;


import lombok.Data;

@Data
public class ExternalIdentifierDTO {
    private String id;
    private String externalIdentifierType;
    private String owner;
    private String baseType;
    private String schemaLocation;
    private String type;
}

