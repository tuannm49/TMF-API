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
public class ShipmentItem_FVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue_FVO product;
    private String quantity;
    @ManyToOne
    @JoinColumn(name = "productReservationRef_id")
    @JsonBackReference
    private ReserveProductStockRef_FVO productReservationRef;
    @ManyToOne
    @JoinColumn(name = "productStockRef_id")
    @JsonBackReference
    private ProductStockRef_FVO productStockRef;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "weight_id")
    @JsonBackReference
    private Quantity weight;
    @OneToMany
    @JoinColumn(name = "ShipmentItem_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> characteristic;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private ShipmentItemActionType action;
    @OneToMany
    @JoinColumn(name = "ShipmentItem_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String sku;
    @ManyToOne
    @JoinColumn(name = "shipmentItemPrice_id")
    @JsonBackReference
    private Price shipmentItemPrice;
}
