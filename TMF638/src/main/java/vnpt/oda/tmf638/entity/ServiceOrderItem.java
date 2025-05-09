package vnpt.oda.tmf638.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "service_order_item")
public class ServiceOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Column(name = "service_order_href")
    private String serviceOrderHref;

    @Column(name = "service_order_id")
    private String serviceOrderId;

    @Column(name = "role")
    private String role;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "item_action")
    private String itemAction;

    @Column(name = "referred_type")
    private String referredType;

    @Column(name = "base_type")
    private String baseType;

    @Column(name = "schema_location")
    private String schemaLocation;

    @Column(name = "type")
    private String type;
}
