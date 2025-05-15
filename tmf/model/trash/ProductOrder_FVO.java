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
public class ProductOrder_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ProductOrder_FVO_id")
    @JsonManagedReference
    private List<Note_FVO> note;
    @ManyToOne
    @JoinColumn(name = "requestedInitialState_id")
    @JsonBackReference
    private InitialProductOrderStateType requestedInitialState;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ProductOrder_FVO_id")
    @JsonManagedReference
    private List<RelatedChannel_FVO> channel;
    private String description;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef_FVO billingAccount;
    @OneToMany
    @JoinColumn(name = "ProductOrder_FVO_id")
    @JsonManagedReference
    private List<ProductOrderItem_FVO> productOrderItem;
    private OffsetDateTime requestedStartDate;
    @OneToMany
    @JoinColumn(name = "ProductOrder_FVO_id")
    @JsonManagedReference
    private List<QuoteRef_FVO> quote;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "ProductOrder_FVO_id")
    @JsonManagedReference
    private List<ProductOrderJeopardyAlert_FVO> productOrderJeopardyAlert;
    @OneToMany
    @JoinColumn(name = "ProductOrder_FVO_id")
    @JsonManagedReference
    private List<PaymentRef_FVO> payment;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime requestedCompletionDate;
    @OneToMany
    @JoinColumn(name = "ProductOrder_FVO_id")
    @JsonManagedReference
    private List<AgreementRef_FVO> agreement;
    @OneToMany
    @JoinColumn(name = "ProductOrder_FVO_id")
    @JsonManagedReference
    private List<OrderPrice_FVO> orderTotalPrice;
    @OneToMany
    @JoinColumn(name = "ProductOrder_FVO_id")
    @JsonManagedReference
    private List<ProductOfferingQualificationRef_FVO> productOfferingQualification;
    @OneToMany
    @JoinColumn(name = "ProductOrder_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalId;
    private String priority;
    @OneToMany
    @JoinColumn(name = "ProductOrder_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    private String notificationContact;
    @OneToMany
    @JoinColumn(name = "ProductOrder_FVO_id")
    @JsonManagedReference
    private List<ProductOrderMilestone_FVO> productOrderMilestone;
    @OneToMany
    @JoinColumn(name = "ProductOrder_FVO_id")
    @JsonManagedReference
    private List<ProductOrderErrorMessage_FVO> productOrderErrorMessage;
    private String category;
    @OneToMany
    @JoinColumn(name = "ProductOrder_FVO_id")
    @JsonManagedReference
    private List<OrderRelationship_FVO> orderRelationship;
}
