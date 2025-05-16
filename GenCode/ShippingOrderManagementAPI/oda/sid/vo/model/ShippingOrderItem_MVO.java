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
import java.util.List;
import oda.sid.vo.model.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingOrderItem_MVO extends Extensible implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRef_MVO product;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "shipment_id")
    @JsonBackReference
    private Shipment_MVO shipment;
    @ManyToOne
    @JoinColumn(name = "shippingOrderItemPrice_id")
    @JsonBackReference
    private ProductPrice_MVO shippingOrderItemPrice;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef_MVO productOffering;
    @ManyToOne
    @JoinColumn(name = "placeTo_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue_MVO placeTo;
    @ManyToOne
    @JoinColumn(name = "shippingInstruction_id")
    @JsonBackReference
    private ShippingInstruction_MVO shippingInstruction;
    @ManyToOne
    @JoinColumn(name = "productOrderItem_id")
    @JsonBackReference
    private ProductOrderItemRef_MVO productOrderItem;
    @OneToMany
    @JoinColumn(name = "ShippingOrderItem_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> relatedParty;
    @ManyToOne
    @JoinColumn(name = "shippingOrderItemOffer_id")
    @JsonBackReference
    private ProductOfferingRef_MVO shippingOrderItemOffer;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private ShippingOrderItemActionType action;
    @ManyToOne
    @JoinColumn(name = "placeFrom_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue_MVO placeFrom;
    private String status;
}
