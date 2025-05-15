package com.example.trash;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Shipment_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Shipment_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "shipmentTracking_id")
    @JsonBackReference
    private ShipmentTrackingRef_MVO shipmentTracking;
    private String description;
    @OneToMany
    @JoinColumn(name = "Shipment_MVO_id")
    @JsonManagedReference
    private List<RelatedShipment_MVO> relatedShipment;
    @ManyToOne
    @JoinColumn(name = "shipmentSpecification_id")
    @JsonBackReference
    private ShipmentSpecificationRefOrValue_MVO shipmentSpecification;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "Shipment_MVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_MVO> attachment;
    @OneToMany
    @JoinColumn(name = "Shipment_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    private String href;
    @Id
    private String id;
    private String state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime deliveryDate;
    @ManyToOne
    @JoinColumn(name = "placeFrom_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue_MVO placeFrom;
    @ManyToOne
    @JoinColumn(name = "shipmentPrice_id")
    @JsonBackReference
    private ProductPrice_MVO shipmentPrice;
    private OffsetDateTime expectedDeliveryDate;
    @ManyToOne
    @JoinColumn(name = "placeTo_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue_MVO placeTo;
    @ManyToOne
    @JoinColumn(name = "weight_id")
    @JsonBackReference
    private Quantity weight;
    @ManyToOne
    @JoinColumn(name = "shippingInstruction_id")
    @JsonBackReference
    private ShippingInstruction_MVO shippingInstruction;
    @OneToMany
    @JoinColumn(name = "Shipment_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> shipmentCharacteristic;
    @OneToMany
    @JoinColumn(name = "Shipment_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> relatedParty;
    private OffsetDateTime collectionDate;
    private String name;
    private OffsetDateTime requestedDeliveryDate;
    @ManyToOne
    @JoinColumn(name = "paymentMethod_id")
    @JsonBackReference
    private PaymentMethodRef_MVO paymentMethod;
    private OffsetDateTime completionDate;
    @OneToMany
    @JoinColumn(name = "Shipment_MVO_id")
    @JsonManagedReference
    private List<ShipmentItem_MVO> shipmentItem;
}
