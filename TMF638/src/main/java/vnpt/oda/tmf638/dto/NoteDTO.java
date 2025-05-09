package vnpt.oda.tmf638.dto;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class NoteDTO {
    private String id;
    private String author;
    private LocalDateTime date;
    private String text;
    private String baseType;
    private String schemaLocation;
    private String type;
}

