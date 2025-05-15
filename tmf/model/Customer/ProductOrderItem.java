package com.example.Customer;

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
public class ProductOrderItem implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_id")
    @JsonManagedReference
    private List<Note> note;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue product;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef productOffering;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_id")
    @JsonManagedReference
    private List<OrderPrice> itemTotalPrice;
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonBackReference
    private AppointmentRef appointment;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef billingAccount;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_id")
    @JsonManagedReference
    private List<ProductOrderItem> productOrderItem;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_id")
    @JsonManagedReference
    private List<OrderItemRelationship> productOrderItemRelationship;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_id")
    @JsonManagedReference
    private List<OrderTerm> itemTerm;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_id")
    @JsonManagedReference
    private List<ProductOfferingQualificationRef> qualification;
    @ManyToOne
    @JoinColumn(name = "productOfferingQualificationItem_id")
    @JsonBackReference
    private ProductOfferingQualificationItemRef productOfferingQualificationItem;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private ItemActionType action;
    @ManyToOne
    @JoinColumn(name = "quoteItem_id")
    @JsonBackReference
    private QuoteItemRef quoteItem;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_id")
    @JsonManagedReference
    private List<OrderPrice> itemPrice;
    @OneToMany
    @JoinColumn(name = "ProductOrderItem_id")
    @JsonManagedReference
    private List<PaymentRef> payment;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ProductOrderItemStateType state;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
