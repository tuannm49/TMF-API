package vnpt.oda.tmf638.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "service_characteristic")
public class ServiceCharacteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

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

