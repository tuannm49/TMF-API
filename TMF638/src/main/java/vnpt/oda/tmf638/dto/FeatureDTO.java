package vnpt.oda.tmf638.dto;


import lombok.Data;
import java.util.List;

@Data
public class FeatureDTO {
    private String id;
    private String name;
    private Boolean isBundle;
    private Boolean isEnabled;
    private String policyConstraint;
    private String baseType;
    private String schemaLocation;
    private String type;
    private List<FeatureCharacteristicDTO> featureCharacteristics;
}

