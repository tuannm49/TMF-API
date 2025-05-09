package vnpt.oda.tmf638.dto;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AttachmentDTO {
    private String id;
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

