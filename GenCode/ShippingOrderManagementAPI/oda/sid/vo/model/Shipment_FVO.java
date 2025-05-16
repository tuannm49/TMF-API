package oda.sid.vo.model;

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
import oda.sid.vo.model.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Shipment_FVO extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Shipment_FVO_id")
    @JsonManagedReference
    private List<Note_FVO> note;
    @ManyToOne
    @JoinColumn(name = "shipmentPrice_id")
    @JsonBackReference
    private ProductPrice_FVO shipmentPrice;
    private OffsetDateTime expectedDeliveryDate;
    @ManyToOne
    @JoinColumn(name = "shipmentTracking_id")
    @JsonBackReference
    private ShipmentTrackingRef_FVO shipmentTracking;
    @ManyToOne
    @JoinColumn(name = "placeTo_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue_FVO placeTo;
    private String description;
    @ManyToOne
    @JoinColumn(name = "weight_id")
    @JsonBackReference
    private Quantity weight;
    @ManyToOne
    @JoinColumn(name = "shippingInstruction_id")
    @JsonBackReference
    private ShippingInstruction_FVO shippingInstruction;
    @OneToMany
    @JoinColumn(name = "Shipment_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> shipmentCharacteristic;
    @OneToMany
    @JoinColumn(name = "Shipment_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_FVO> relatedParty;
    private OffsetDateTime collectionDate;
    @OneToMany
    @JoinColumn(name = "Shipment_FVO_id")
    @JsonManagedReference
    private List<RelatedShipment_FVO> relatedShipment;
    @ManyToOne
    @JoinColumn(name = "shipmentSpecification_id")
    @JsonBackReference
    private ShipmentSpecificationRefOrValue_FVO shipmentSpecification;
    @OneToMany
    @JoinColumn(name = "Shipment_FVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_FVO> attachment;
    private String name;
    private OffsetDateTime requestedDeliveryDate;
    @ManyToOne
    @JoinColumn(name = "paymentMethod_id")
    @JsonBackReference
    private PaymentMethodRef_FVO paymentMethod;
    @OneToMany
    @JoinColumn(name = "Shipment_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    private String state;
    @OneToMany
    @JoinColumn(name = "Shipment_FVO_id")
    @JsonManagedReference
    private List<ShipmentItem_FVO> shipmentItem;
    private OffsetDateTime deliveryDate;
    @ManyToOne
    @JoinColumn(name = "placeFrom_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue_FVO placeFrom;
}
