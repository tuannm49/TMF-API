package vnpt.oda.tmf638.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "feature")
public class Feature {
    @Id
    private String id;

    private String serviceId;
    private String name;
    private Boolean isBundle;
    private Boolean isEnabled;
    private String policyConstraint;
    private String baseType;
    private String schemaLocation;
    private String type;

    private List<FeatureCharacteristic> featureCharacteristics;
}

