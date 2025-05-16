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
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.tmf.model.customer.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOrder extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ProductOrder_id")
    @JsonManagedReference
    private List<Note> note;
    @ManyToOne
    @JoinColumn(name = "requestedInitialState_id")
    @JsonBackReference
    private InitialProductOrderStateType requestedInitialState;
    @OneToMany
    @JoinColumn(name = "ProductOrder_id")
    @JsonManagedReference
    private List<RelatedChannel> channel;
    private String description;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef billingAccount;
    @OneToMany
    @JoinColumn(name = "ProductOrder_id")
    @JsonManagedReference
    private List<ProductOrderItem> productOrderItem;
    private OffsetDateTime requestedStartDate;
    @OneToMany
    @JoinColumn(name = "ProductOrder_id")
    @JsonManagedReference
    private List<QuoteRef> quote;
    @OneToMany
    @JoinColumn(name = "ProductOrder_id")
    @JsonManagedReference
    private List<ProductOrderJeopardyAlert> productOrderJeopardyAlert;
    @OneToMany
    @JoinColumn(name = "ProductOrder_id")
    @JsonManagedReference
    private List<PaymentRef> payment;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ProductOrderStateType state;
    private OffsetDateTime cancellationDate;
    private OffsetDateTime requestedCompletionDate;
    @OneToMany
    @JoinColumn(name = "ProductOrder_id")
    @JsonManagedReference
    private List<AgreementRef> agreement;
    private String cancellationReason;
    @OneToMany
    @JoinColumn(name = "ProductOrder_id")
    @JsonManagedReference
    private List<OrderPrice> orderTotalPrice;
    @OneToMany
    @JoinColumn(name = "ProductOrder_id")
    @JsonManagedReference
    private List<ProductOfferingQualificationRef> productOfferingQualification;
    @OneToMany
    @JoinColumn(name = "ProductOrder_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalId;
    private String priority;
    @OneToMany
    @JoinColumn(name = "ProductOrder_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    private OffsetDateTime creationDate;
    private String notificationContact;
    @OneToMany
    @JoinColumn(name = "ProductOrder_id")
    @JsonManagedReference
    private List<ProductOrderMilestone> productOrderMilestone;
    @OneToMany
    @JoinColumn(name = "ProductOrder_id")
    @JsonManagedReference
    private List<ProductOrderErrorMessage> productOrderErrorMessage;
    private OffsetDateTime expectedCompletionDate;
    private OffsetDateTime completionDate;
    private String category;
    @OneToMany
    @JoinColumn(name = "ProductOrder_id")
    @JsonManagedReference
    private List<OrderRelationship> orderRelationship;
}
