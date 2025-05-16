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
import oda.sid.vo.model.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkOrder_FVO extends Entity implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonBackReference
    private Note note;
    @OneToMany
    @JoinColumn(name = "WorkOrder_FVO_id")
    @JsonManagedReference
    private List<RelatedChannel_FVO> channel;
    private String description;
    private OffsetDateTime stateChangeDate;
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonBackReference
    private AppointmentRef appointment;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef billingAccount;
    private OffsetDateTime requestedStartDate;
    @OneToMany
    @JoinColumn(name = "WorkOrder_FVO_id")
    @JsonManagedReference
    private List<QuoteRef> quote;
    @OneToMany
    @JoinColumn(name = "WorkOrder_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "WorkOrder_FVO_id")
    @JsonManagedReference
    private List<PaymentRef> payment;
    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private PlaceRefOrValue_FVO place;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private WorkOrderStateType state;
    private OffsetDateTime cancellationDate;
    private OffsetDateTime requestedCompletionDate;
    @OneToMany
    @JoinColumn(name = "WorkOrder_FVO_id")
    @JsonManagedReference
    private List<AgreementRef> agreement;
    private String cancellationReason;
    @OneToMany
    @JoinColumn(name = "WorkOrder_FVO_id")
    @JsonManagedReference
    private List<OrderPrice_FVO> orderTotalPrice;
    @OneToMany
    @JoinColumn(name = "WorkOrder_FVO_id")
    @JsonManagedReference
    private List<RelatedEntity_FVO> relatedEntity;
    @OneToMany
    @JoinColumn(name = "WorkOrder_FVO_id")
    @JsonManagedReference
    private List<OrderRelationship> workOrderRelationship;
    private String priority;
    @OneToMany
    @JoinColumn(name = "WorkOrder_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_FVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "WorkOrder_FVO_id")
    @JsonManagedReference
    private List<ProductOrderRef> relatedProductOrder;
    private String notificationContact;
    private OffsetDateTime completionDate;
    private OffsetDateTime expectedCompletionDate;
    private String category;
    private OffsetDateTime orderDate;
    private OffsetDateTime startDate;
    @OneToMany
    @JoinColumn(name = "WorkOrder_FVO_id")
    @JsonManagedReference
    private List<WorkOrderItem_FVO> workOrderItem;
}
