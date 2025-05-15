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
public class WorkOrder_MVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonBackReference
    private Note_MVO note;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "WorkOrder_MVO_id")
    @JsonManagedReference
    private List<RelatedChannel_MVO> channel;
    private String description;
    private OffsetDateTime stateChangeDate;
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonBackReference
    private AppointmentRef_MVO appointment;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef_MVO billingAccount;
    private OffsetDateTime requestedStartDate;
    @OneToMany
    @JoinColumn(name = "WorkOrder_MVO_id")
    @JsonManagedReference
    private List<QuoteRef_MVO> quote;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "WorkOrder_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "WorkOrder_MVO_id")
    @JsonManagedReference
    private List<PaymentRef_MVO> payment;
    private String href;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private PlaceRefOrValue_MVO place;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private WorkOrderStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime cancellationDate;
    private OffsetDateTime requestedCompletionDate;
    @OneToMany
    @JoinColumn(name = "WorkOrder_MVO_id")
    @JsonManagedReference
    private List<AgreementRef_MVO> agreement;
    private String cancellationReason;
    @OneToMany
    @JoinColumn(name = "WorkOrder_MVO_id")
    @JsonManagedReference
    private List<OrderPrice_MVO> orderTotalPrice;
    @OneToMany
    @JoinColumn(name = "WorkOrder_MVO_id")
    @JsonManagedReference
    private List<RelatedEntity_MVO> relatedEntity;
    @OneToMany
    @JoinColumn(name = "WorkOrder_MVO_id")
    @JsonManagedReference
    private List<OrderRelationship_MVO> workOrderRelationship;
    private String priority;
    @OneToMany
    @JoinColumn(name = "WorkOrder_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "WorkOrder_MVO_id")
    @JsonManagedReference
    private List<ProductOrderRef_MVO> relatedProductOrder;
    private String notificationContact;
    private OffsetDateTime completionDate;
    private OffsetDateTime expectedCompletionDate;
    private String category;
    private OffsetDateTime startDate;
    @OneToMany
    @JoinColumn(name = "WorkOrder_MVO_id")
    @JsonManagedReference
    private List<WorkOrderItem_MVO> workOrderItem;
}
