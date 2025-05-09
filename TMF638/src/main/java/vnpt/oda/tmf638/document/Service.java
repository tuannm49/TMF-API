package vnpt.oda.tmf638.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "service")
public class Service {
    @Id
    private String id;

    private String href;
    private String category;
    private String description;
    private LocalDateTime endDate;
    private Boolean hasStarted;
    private Boolean isBundle;
    private Boolean isServiceEnabled;
    private Boolean isStateful;
    private String name;
    private String operatingStatus;
    private LocalDateTime serviceDate;
    private String serviceType;
    private LocalDateTime startDate;
    private String startMode;
    private String state;
    private String baseType;
    private String schemaLocation;
    private String type;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Quan hệ nhúng hoặc tham chiếu
    private List<ServiceCharacteristic> serviceCharacteristics;
    private List<Attachment> attachments;
}

