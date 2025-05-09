package vnpt.oda.tmf638.dto;


import lombok.Data;

@Data
public class RelatedPartyDTO {
    private String id;
    private String partyId;
    private String role;
    private String href;
    private String name;
    private String referredType;
    private String baseType;
    private String schemaLocation;
    private String type;
}

