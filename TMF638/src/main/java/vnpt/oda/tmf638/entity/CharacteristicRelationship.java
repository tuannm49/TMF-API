package vnpt.oda.tmf638.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "characteristic_relationship")
public class CharacteristicRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "characteristic_id", nullable = false)
    private ServiceCharacteristic characteristic;

    @ManyToOne
    @JoinColumn(name = "related_characteristic_id", nullable = false)
    private ServiceCharacteristic relatedCharacteristic;

    @Column(name = "relationship_type")
    private String relationshipType;

    @Column(name = "base_type")
    private String baseType;

    @Column(name = "schema_location")
    private String schemaLocation;

    @Column(name = "type")
    private String type;
}

