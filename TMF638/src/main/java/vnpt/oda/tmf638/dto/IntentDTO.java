package vnpt.oda.tmf638.dto;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class IntentDTO {
    private String id;
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
