package vnpt.oda.tmf638.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "attachment")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Column(name = "attachment_type")
    private String attachmentType;

    @Column(name = "content")
    private String content;

    @Column(name = "description")
    private String description;

    @Column(name = "href")
    private String href;

    @Column(name = "mime_type")
    private String mimeType;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private Double size;

    @Column(name = "url")
    private String url;

    @Column(name = "valid_for_start")
    private LocalDateTime validForStart;

    @Column(name = "valid_for_end")
    private LocalDateTime validForEnd;

    @Column(name = "base_type")
    private String baseType;

    @Column(name = "schema_location")
    private String schemaLocation;

    @Column(name = "type")
    private String type;
}
