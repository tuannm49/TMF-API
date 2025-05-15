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
public class WorkOrder implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonBackReference
    private Note note;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "WorkOrder_id")
    @JsonManagedReference
    private List<RelatedChannel> channel;
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
    @JoinColumn(name = "WorkOrder_id")
    @JsonManagedReference
    private List<QuoteRef> quote;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "WorkOrder_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "WorkOrder_id")
    @JsonManagedReference
    private List<PaymentRef> payment;
    private String href;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private PlaceRefOrValue place;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private WorkOrderStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime cancellationDate;
    private OffsetDateTime requestedCompletionDate;
    @OneToMany
    @JoinColumn(name = "WorkOrder_id")
    @JsonManagedReference
    private List<AgreementRef> agreement;
    private String cancellationReason;
    @OneToMany
    @JoinColumn(name = "WorkOrder_id")
    @JsonManagedReference
    private List<OrderPrice> orderTotalPrice;
    @OneToMany
    @JoinColumn(name = "WorkOrder_id")
    @JsonManagedReference
    private List<RelatedEntity> relatedEntity;
    @OneToMany
    @JoinColumn(name = "WorkOrder_id")
    @JsonManagedReference
    private List<OrderRelationship> workOrderRelationship;
    private String priority;
    @OneToMany
    @JoinColumn(name = "WorkOrder_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> relatedParty;
    @OneToMany
    @JoinColumn(name = "WorkOrder_id")
    @JsonManagedReference
    private List<ProductOrderRef> relatedProductOrder;
    private String notificationContact;
    private OffsetDateTime completionDate;
    private OffsetDateTime expectedCompletionDate;
    private String category;
    private OffsetDateTime orderDate;
    private OffsetDateTime startDate;
    @OneToMany
    @JoinColumn(name = "WorkOrder_id")
    @JsonManagedReference
    private List<WorkOrderItem> workOrderItem;
}
