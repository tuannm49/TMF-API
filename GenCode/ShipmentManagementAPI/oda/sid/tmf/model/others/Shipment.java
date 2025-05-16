package oda.sid.tmf.model.others;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Shipment implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private OffsetDateTime collectionDate;
    private OffsetDateTime completionDate;
    private OffsetDateTime deliveryDate;
    private String description;
    private OffsetDateTime expectedDeliveryDate;
    private String name;
    private OffsetDateTime requestedDeliveryDate;
    @OneToMany
    @JoinColumn(name = "Shipment_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @OneToMany
    @JoinColumn(name = "Shipment_id")
    @JsonManagedReference
    private List<ExternalReference> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "Shipment_id")
    @JsonManagedReference
    private List<Note> note;
    @ManyToOne
    @JoinColumn(name = "paymentMethod_id")
    @JsonBackReference
    private PaymentMethodRef paymentMethod;
    @ManyToOne
    @JoinColumn(name = "placeFrom_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue placeFrom;
    @ManyToOne
    @JoinColumn(name = "placeTo_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue placeTo;
    @OneToMany
    @JoinColumn(name = "Shipment_id")
    @JsonManagedReference
    private List<RelatedPartyWithContactInfo> relatedParty;
    @ManyToOne
    @JoinColumn(name = "relatedShipment_id")
    @JsonBackReference
    private RelatedShipment relatedShipment;
    @OneToMany
    @JoinColumn(name = "Shipment_id")
    @JsonManagedReference
    private List<ShipmentItem> shipmentItem;
    @ManyToOne
    @JoinColumn(name = "shipmentPrice_id")
    @JsonBackReference
    private Price shipmentPrice;
    @ManyToOne
    @JoinColumn(name = "shipmentSpecification_id")
    @JsonBackReference
    private ShipmentSpecificationRefOrValue shipmentSpecification;
    @ManyToOne
    @JoinColumn(name = "shipmentTracking_id")
    @JsonBackReference
    private ShipmentTrackingRef shipmentTracking;
    @ManyToOne
    @JoinColumn(name = "shippingInstruction_id")
    @JsonBackReference
    private ShippingInstruction shippingInstruction;
    @ManyToOne
    @JoinColumn(name = "weight_id")
    @JsonBackReference
    private Quantity weight;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
