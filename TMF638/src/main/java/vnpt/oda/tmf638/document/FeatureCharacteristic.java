package vnpt.oda.tmf638.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "feature_characteristic")
public class FeatureCharacteristic {
    @Id
    private String id;

    private String featureId;
    private String name;
    private String valueType;
    private String value;
    private String baseType;
    private String schemaLocation;
    private String type;
}
