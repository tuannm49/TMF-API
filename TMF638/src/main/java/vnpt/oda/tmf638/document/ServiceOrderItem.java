package vnpt.oda.tmf638.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "service_order_item")
public class ServiceOrderItem {
    @Id
    private String id;

    private String serviceId;
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

