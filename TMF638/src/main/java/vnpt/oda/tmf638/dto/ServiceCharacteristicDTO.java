package vnpt.oda.tmf638.dto;


import lombok.Data;

@Data
public class ServiceCharacteristicDTO {
    private String id;
    private String name;
    private String valueType;
    private String value;
    private String baseType;
    private String schemaLocation;
    private String type;
}
