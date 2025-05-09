package vnpt.oda.tmf638.dto;


import lombok.Data;

@Data
public class SupportingResourceDTO {
    private String id;
    private String resourceId;
    private String href;
    private String referredType;
    private String baseType;
    private String schemaLocation;
    private String type;
}
