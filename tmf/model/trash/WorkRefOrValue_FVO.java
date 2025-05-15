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
public class WorkRefOrValue_FVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonBackReference
    private Note note;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_FVO_id")
    @JsonManagedReference
    private List<WorkRelationship_FVO> workRelationship;
    @JsonProperty("@referredType")
    private String referredType;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_FVO_id")
    @JsonManagedReference
    private List<WorkRefOrValue_FVO> relatedWork;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "actualDuration_id")
    @JsonBackReference
    private Quantity actualDuration;
    @ManyToOne
    @JoinColumn(name = "workTimeSlot_id")
    @JsonBackReference
    private TimePeriod workTimeSlot;
    private String description;
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonBackReference
    private AppointmentRef appointment;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_FVO_id")
    @JsonManagedReference
    private List<WorkPrice_FVO> workPrice;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "workSpecification_id")
    @JsonBackReference
    private WorkSpecificationRefOrValue_FVO workSpecification;
    private String href;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_FVO_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue_FVO> place;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private WorkStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_FVO_id")
    @JsonManagedReference
    private List<WorkforceEmployeeAssignment_FVO> workforceEmployeeAssignment;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_FVO_id")
    @JsonManagedReference
    private List<AgreementRef> agreement;
    @ManyToOne
    @JoinColumn(name = "quantity_id")
    @JsonBackReference
    private Quantity quantity;
    @ManyToOne
    @JoinColumn(name = "scheduledDuration_id")
    @JsonBackReference
    private Quantity scheduledDuration;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_FVO_id")
    @JsonManagedReference
    private List<RelatedWorkOrderItem_FVO> relatedWorkOrderItem;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_FVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> workCharacteristic;
    private Object percentageComplete;
    @ManyToOne
    @JoinColumn(name = "currentDuration_id")
    @JsonBackReference
    private Quantity currentDuration;
    private String name;
    private String workType;
    @ManyToOne
    @JoinColumn(name = "workforceEmployeeTravel_id")
    @JsonBackReference
    private WorkforceEmployeeTravel_FVO workforceEmployeeTravel;
    private OffsetDateTime completionDate;
    private OffsetDateTime expectedCompletionDate;
    private String workPriority;
    private OffsetDateTime orderDate;
}
