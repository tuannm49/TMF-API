package vnpt.oda.tmf638.dto;


import lombok.Data;

@Data
public class SupportingServiceDTO {
    private String id;
    private String supportingServiceId;
    private String href;
    private String referredType;
    private String baseType;
    private String schemaLocation;
    private String type;
}

