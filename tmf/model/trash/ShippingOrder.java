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
public class ShippingOrder implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ShippingOrder_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "ShippingOrder_id")
    @JsonManagedReference
    private List<Characteristic> shippingOrderCharacteristic;
    @ManyToOne
    @JoinColumn(name = "productOrderRef_id")
    @JsonBackReference
    private ProductOrderRef productOrderRef;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "shippingOrderPrice_id")
    @JsonBackReference
    private Price shippingOrderPrice;
    @ManyToOne
    @JoinColumn(name = "placeTo_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue placeTo;
    @ManyToOne
    @JoinColumn(name = "shippingInstruction_id")
    @JsonBackReference
    private ShippingInstruction shippingInstruction;
    @ManyToOne
    @JoinColumn(name = "relatedShippingOrder_id")
    @JsonBackReference
    private RelatedShippingOrder relatedShippingOrder;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "ShippingOrder_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "shippingOrderOffering_id")
    @JsonBackReference
    private ProductOfferingRef shippingOrderOffering;
    private OffsetDateTime lastUpdate;
    private OffsetDateTime completionDate;
    private String href;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ShippingOrderStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "ShippingOrder_id")
    @JsonManagedReference
    private List<ShippingOrderItem> shippingOrderItem;
    @ManyToOne
    @JoinColumn(name = "placeFrom_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue placeFrom;
}
