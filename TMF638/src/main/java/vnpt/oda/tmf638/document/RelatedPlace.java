package vnpt.oda.tmf638.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "related_place")
public class RelatedPlace {
    @Id
    private String id;

    private String serviceId;
    private String placeId;
    private String role;
    private String placeType;
    private String baseType;
    private String schemaLocation;
    private String type;
}

