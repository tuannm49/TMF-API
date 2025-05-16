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
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.vo.model.Entity_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOrder_MVO extends Entity_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ProductOrder_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    @OneToMany
    @JoinColumn(name = "ProductOrder_MVO_id")
    @JsonManagedReference
    private List<RelatedChannel_MVO> channel;
    private String description;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef_MVO billingAccount;
    @OneToMany
    @JoinColumn(name = "ProductOrder_MVO_id")
    @JsonManagedReference
    private List<ProductOrderItem_MVO> productOrderItem;
    private OffsetDateTime requestedStartDate;
    @OneToMany
    @JoinColumn(name = "ProductOrder_MVO_id")
    @JsonManagedReference
    private List<QuoteRef_MVO> quote;
    @OneToMany
    @JoinColumn(name = "ProductOrder_MVO_id")
    @JsonManagedReference
    private List<ProductOrderJeopardyAlert_MVO> productOrderJeopardyAlert;
    @OneToMany
    @JoinColumn(name = "ProductOrder_MVO_id")
    @JsonManagedReference
    private List<PaymentRef_MVO> payment;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ProductOrderStateType state;
    private OffsetDateTime cancellationDate;
    private OffsetDateTime requestedCompletionDate;
    @OneToMany
    @JoinColumn(name = "ProductOrder_MVO_id")
    @JsonManagedReference
    private List<AgreementRef_MVO> agreement;
    private String cancellationReason;
    @OneToMany
    @JoinColumn(name = "ProductOrder_MVO_id")
    @JsonManagedReference
    private List<OrderPrice_MVO> orderTotalPrice;
    @OneToMany
    @JoinColumn(name = "ProductOrder_MVO_id")
    @JsonManagedReference
    private List<ProductOfferingQualificationRef_MVO> productOfferingQualification;
    @OneToMany
    @JoinColumn(name = "ProductOrder_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalId;
    private String priority;
    @OneToMany
    @JoinColumn(name = "ProductOrder_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private String notificationContact;
    @OneToMany
    @JoinColumn(name = "ProductOrder_MVO_id")
    @JsonManagedReference
    private List<ProductOrderMilestone_MVO> productOrderMilestone;
    @OneToMany
    @JoinColumn(name = "ProductOrder_MVO_id")
    @JsonManagedReference
    private List<ProductOrderErrorMessage_MVO> productOrderErrorMessage;
    private OffsetDateTime expectedCompletionDate;
    private OffsetDateTime completionDate;
    private String category;
    @OneToMany
    @JoinColumn(name = "ProductOrder_MVO_id")
    @JsonManagedReference
    private List<OrderRelationship_MVO> orderRelationship;
}
