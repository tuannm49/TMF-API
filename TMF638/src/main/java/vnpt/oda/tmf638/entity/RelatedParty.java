package vnpt.oda.tmf638.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "related_party")
public class RelatedParty {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Column(name = "party_id")
    private String partyId;

    @Column(name = "role")
    private String role;

    @Column(name = "href")
    private String href;

    @Column(name = "name")
    private String name;

    @Column(name = "referred_type")
    private String referredType;

    @Column(name = "base_type")
    private String baseType;

    @Column(name = "schema_location")
    private String schemaLocation;

    @Column(name = "type")
    private String type;
}

