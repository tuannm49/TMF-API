package oda.sid.tmf.model.customer;

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
import oda.sid.tmf.model.customer.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOrderItem extends Extensible implements java.io.Serializable {
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
    private String id;
}
