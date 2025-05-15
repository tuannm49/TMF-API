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
public class Shipment_Create implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Shipment_Create_id")
    @JsonManagedReference
    private List<Note> note;
    @ManyToOne
    @JoinColumn(name = "shipmentPrice_id")
    @JsonBackReference
    private Price shipmentPrice;
    private OffsetDateTime expectedDeliveryDate;
    @ManyToOne
    @JoinColumn(name = "shipmentTracking_id")
    @JsonBackReference
    private ShipmentTrackingRef shipmentTracking;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "placeTo_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue placeTo;
    private String description;
    @ManyToOne
    @JoinColumn(name = "shippingInstruction_id")
    @JsonBackReference
    private ShippingInstruction shippingInstruction;
    @ManyToOne
    @JoinColumn(name = "weight_id")
    @JsonBackReference
    private Quantity weight;
    @OneToMany
    @JoinColumn(name = "Shipment_Create_id")
    @JsonManagedReference
    private List<RelatedPartyWithContactInfo> relatedParty;
    private OffsetDateTime collectionDate;
    @OneToMany
    @JoinColumn(name = "Shipment_Create_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @ManyToOne
    @JoinColumn(name = "relatedShipment_id")
    @JsonBackReference
    private RelatedShipment relatedShipment;
    @ManyToOne
    @JoinColumn(name = "shipmentSpecification_id")
    @JsonBackReference
    private ShipmentSpecificationRefOrValue shipmentSpecification;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    private OffsetDateTime requestedDeliveryDate;
    @OneToMany
    @JoinColumn(name = "Shipment_Create_id")
    @JsonManagedReference
    private List<ExternalReference> externalIdentifier;
    @ManyToOne
    @JoinColumn(name = "paymentMethod_id")
    @JsonBackReference
    private PaymentMethodRef paymentMethod;
    private OffsetDateTime completionDate;
    @OneToMany
    @JoinColumn(name = "Shipment_Create_id")
    @JsonManagedReference
    private List<ShipmentItem> shipmentItem;
    private OffsetDateTime deliveryDate;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "placeFrom_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue placeFrom;
}
