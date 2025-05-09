package vnpt.oda.tmf638.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "external_identifier")
public class ExternalIdentifier {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Column(name = "external_identifier_type")
    private String externalIdentifierType;

    @Column(name = "owner")
    private String owner;

    @Column(name = "base_type")
    private String baseType;

    @Column(name = "schema_location")
    private String schemaLocation;

    @Column(name = "type")
    private String type;
}

