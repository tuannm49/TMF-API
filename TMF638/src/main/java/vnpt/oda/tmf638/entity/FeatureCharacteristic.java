package vnpt.oda.tmf638.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "feature_characteristic")
public class FeatureCharacteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "feature_id", nullable = false)
    private Feature feature;

    @Column(name = "name")
    private String name;

    @Column(name = "value_type")
    private String valueType;

    @Column(name = "value")
    private String value;

    @Column(name = "base_type")
    private String baseType;

    @Column(name = "schema_location")
    private String schemaLocation;

    @Column(name = "type")
    private String type;
}

