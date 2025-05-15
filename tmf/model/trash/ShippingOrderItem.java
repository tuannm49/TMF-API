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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingOrderItem implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRef product;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "shipment_id")
    @JsonBackReference
    private Shipment shipment;
    @ManyToOne
    @JoinColumn(name = "shippingOrderItemPrice_id")
    @JsonBackReference
    private ProductPrice shippingOrderItemPrice;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef productOffering;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "placeTo_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue placeTo;
    @ManyToOne
    @JoinColumn(name = "shippingInstruction_id")
    @JsonBackReference
    private ShippingInstruction shippingInstruction;
    @ManyToOne
    @JoinColumn(name = "productOrderItem_id")
    @JsonBackReference
    private ProductOrderItemRef productOrderItem;
    @OneToMany
    @JoinColumn(name = "ShippingOrderItem_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "shippingOrderItemOffer_id")
    @JsonBackReference
    private ProductOfferingRef shippingOrderItemOffer;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private ShippingOrderItemActionType action;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "placeFrom_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue placeFrom;
    private String status;
}
