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
public class WorkRefOrValue implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonBackReference
    private Note note;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_id")
    @JsonManagedReference
    private List<WorkRelationship> workRelationship;
    @JsonProperty("@referredType")
    private String referredType;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "actualDuration_id")
    @JsonBackReference
    private Quantity actualDuration;
    private String description;
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonBackReference
    private AppointmentRef appointment;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_id")
    @JsonManagedReference
    private List<WorkPrice> workPrice;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "workSpecification_id")
    @JsonBackReference
    private WorkSpecificationRef workSpecification;
    @ManyToOne
    @JoinColumn(name = "plannedDuration_id")
    @JsonBackReference
    private Quantity plannedDuration;
    @Id
    private String id;
    private String href;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue> place;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private WorkStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_id")
    @JsonManagedReference
    private List<WorkforceEmployeeAssignment> workforceEmployeeAssignment;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_id")
    @JsonManagedReference
    private List<AgreementRef> agreement;
    @ManyToOne
    @JoinColumn(name = "quantity_id")
    @JsonBackReference
    private Quantity quantity;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_id")
    @JsonManagedReference
    private List<WorkRefOrValue> work;
    @ManyToOne
    @JoinColumn(name = "scheduledDuration_id")
    @JsonBackReference
    private Quantity scheduledDuration;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_id")
    @JsonManagedReference
    private List<Characteristic> workCharacteristic;
    @ManyToOne
    @JoinColumn(name = "deliveryTimeSlot_id")
    @JsonBackReference
    private TimePeriod deliveryTimeSlot;
    private Object percentageComplete;
    private String name;
    private String workType;
    @ManyToOne
    @JoinColumn(name = "currentDuration_id")
    @JsonBackReference
    private Quantity currentDuration;
    private OffsetDateTime completionDate;
    private OffsetDateTime expectedCompletionDate;
    private String workPriority;
    private OffsetDateTime orderDate;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_id")
    @JsonManagedReference
    private List<RelatedWorkOrderItem> workOrderItem;
}
