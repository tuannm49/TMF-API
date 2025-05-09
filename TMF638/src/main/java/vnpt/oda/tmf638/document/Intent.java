package vnpt.oda.tmf638.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "intent")
public class Intent {
    @Id
    private String id;

    private String serviceId;
    private String context;
    private LocalDateTime creationDate;
    private String description;
    private Boolean isBundle;
    private LocalDateTime lastUpdate;
    private String lifecycleStatus;
    private String name;
    private String priority;
    private String href;
    private String baseType;
    private String schemaLocation;
    private String type;
}

