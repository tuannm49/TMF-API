package vnpt.oda.tmf638.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "intent")
public class Intent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Column(name = "context")
    private String context;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "description")
    private String description;

    @Column(name = "is_bundle")
    private Boolean isBundle;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @Column(name = "lifecycle_status")
    private String lifecycleStatus;

    @Column(name = "name")
    private String name;

    @Column(name = "priority")
    private String priority;

    @Column(name = "href")
    private String href;

    @Column(name = "base_type")
    private String baseType;

    @Column(name = "schema_location")
    private String schemaLocation;

    @Column(name = "type")
    private String type;
}
