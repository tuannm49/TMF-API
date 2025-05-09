package vnpt.oda.tmf638.dto;


import lombok.Data;

@Data
public class ServiceOrderItemDTO {
    private String id;
    private String serviceOrderHref;
    private String serviceOrderId;
    private String role;
    private String itemId;
    private String itemAction;
    private String referredType;
    private String baseType;
    private String schemaLocation;
    private String type;
}

