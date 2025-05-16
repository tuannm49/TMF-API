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
import oda.sid.tmf.model.others.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Shipment extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Shipment_id")
    @JsonManagedReference
    private List<Note> note;
    @ManyToOne
    @JoinColumn(name = "shipmentPrice_id")
    @JsonBackReference
    private ProductPrice shipmentPrice;
    private OffsetDateTime expectedDeliveryDate;
    @ManyToOne
    @JoinColumn(name = "shipmentTracking_id")
    @JsonBackReference
    private ShipmentTrackingRef shipmentTracking;
    @ManyToOne
    @JoinColumn(name = "placeTo_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue placeTo;
    private String description;
    @ManyToOne
    @JoinColumn(name = "weight_id")
    @JsonBackReference
    private Quantity weight;
    @ManyToOne
    @JoinColumn(name = "shippingInstruction_id")
    @JsonBackReference
    private ShippingInstruction shippingInstruction;
    @OneToMany
    @JoinColumn(name = "Shipment_id")
    @JsonManagedReference
    private List<Characteristic> shipmentCharacteristic;
    @OneToMany
    @JoinColumn(name = "Shipment_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> relatedParty;
    private OffsetDateTime collectionDate;
    @OneToMany
    @JoinColumn(name = "Shipment_id")
    @JsonManagedReference
    private List<RelatedShipment> relatedShipment;
    @ManyToOne
    @JoinColumn(name = "shipmentSpecification_id")
    @JsonBackReference
    private ShipmentSpecificationRefOrValue shipmentSpecification;
    @OneToMany
    @JoinColumn(name = "Shipment_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    private String name;
    private OffsetDateTime requestedDeliveryDate;
    @ManyToOne
    @JoinColumn(name = "paymentMethod_id")
    @JsonBackReference
    private PaymentMethodRef paymentMethod;
    @OneToMany
    @JoinColumn(name = "Shipment_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    private OffsetDateTime completionDate;
    private String state;
    @OneToMany
    @JoinColumn(name = "Shipment_id")
    @JsonManagedReference
    private List<ShipmentItem> shipmentItem;
    private OffsetDateTime deliveryDate;
    @ManyToOne
    @JoinColumn(name = "placeFrom_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue placeFrom;
}
