package vnpt.oda.tmf638.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "supporting_service")
public class SupportingService {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @ManyToOne
    @JoinColumn(name = "supporting_service_id")
    private Service supportingService;

    @Column(name = "href")
    private String href;

    @Column(name = "referred_type")
    private String referredType;

    @Column(name = "base_type")
    private String baseType;

    @Column(name = "schema_location")
    private String schemaLocation;

    @Column(name = "type")
    private String type;
}
