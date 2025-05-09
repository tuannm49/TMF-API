package vnpt.oda.tmf638.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "note")
public class Note {
    @Id
    private String id;

    private String serviceId;
    private String author;
    private LocalDateTime date;
    private String text;
    private String baseType;
    private String schemaLocation;
    private String type;
}

