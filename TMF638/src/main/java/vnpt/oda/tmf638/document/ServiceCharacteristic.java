package vnpt.oda.tmf638.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "service_characteristic")
public class ServiceCharacteristic {
    @Id
    private String id;

    private String serviceId; // Tham chiếu đến Service

    private String name;
    private String valueType;
    private String value;
    private String baseType;
    private String schemaLocation;
    private String type;
}

