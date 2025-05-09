package vnpt.oda.tmf638.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "attachment")
public class Attachment {
    @Id
    private String id;

    private String serviceId; // Tham chiếu đến Service

    private String attachmentType;
    private String content;
    private String description;
    private String href;
    private String mimeType;
    private String name;
    private Double size;
    private String url;
    private LocalDateTime validForStart;
    private LocalDateTime validForEnd;
    private String baseType;
    private String schemaLocation;
    private String type;
}

