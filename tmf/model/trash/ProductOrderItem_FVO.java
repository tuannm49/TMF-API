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
public class ProductOrderItem_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_FVO_id")
    @JsonManagedReference
    private List<Note_FVO> note;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue_FVO product;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef_FVO productOffering;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_FVO_id")
    @JsonManagedReference
    private List<OrderPrice_FVO> itemTotalPrice;
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonBackReference
    private AppointmentRef_FVO appointment;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef_FVO billingAccount;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_FVO_id")
    @JsonManagedReference
    private List<ProductOrderItem_FVO> productOrderItem;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_FVO_id")
    @JsonManagedReference
    private List<OrderItemRelationship_FVO> productOrderItemRelationship;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_FVO_id")
    @JsonManagedReference
    private List<OrderTerm_FVO> itemTerm;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_FVO_id")
    @JsonManagedReference
    private List<ProductOfferingQualificationRef_FVO> qualification;
    @ManyToOne
    @JoinColumn(name = "productOfferingQualificationItem_id")
    @JsonBackReference
    private ProductOfferingQualificationItemRef_FVO productOfferingQualificationItem;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private ItemActionType action;
    @ManyToOne
    @JoinColumn(name = "quoteItem_id")
    @JsonBackReference
    private QuoteItemRef_FVO quoteItem;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_FVO_id")
    @JsonManagedReference
    private List<OrderPrice_FVO> itemPrice;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_FVO_id")
    @JsonManagedReference
    private List<PaymentRef_FVO> payment;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ProductOrderItemStateType state;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
