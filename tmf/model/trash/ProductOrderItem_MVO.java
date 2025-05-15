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
public class ProductOrderItem_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue_MVO product;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef_MVO productOffering;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_MVO_id")
    @JsonManagedReference
    private List<OrderPrice_MVO> itemTotalPrice;
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonBackReference
    private AppointmentRef_MVO appointment;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef_MVO billingAccount;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_MVO_id")
    @JsonManagedReference
    private List<ProductOrderItem_MVO> productOrderItem;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_MVO_id")
    @JsonManagedReference
    private List<OrderItemRelationship_MVO> productOrderItemRelationship;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_MVO_id")
    @JsonManagedReference
    private List<OrderTerm_MVO> itemTerm;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_MVO_id")
    @JsonManagedReference
    private List<ProductOfferingQualificationRef_MVO> qualification;
    @ManyToOne
    @JoinColumn(name = "productOfferingQualificationItem_id")
    @JsonBackReference
    private ProductOfferingQualificationItemRef_MVO productOfferingQualificationItem;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private ItemActionType action;
    @ManyToOne
    @JoinColumn(name = "quoteItem_id")
    @JsonBackReference
    private QuoteItemRef_MVO quoteItem;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_MVO_id")
    @JsonManagedReference
    private List<OrderPrice_MVO> itemPrice;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_MVO_id")
    @JsonManagedReference
    private List<PaymentRef_MVO> payment;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ProductOrderItemStateType state;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
