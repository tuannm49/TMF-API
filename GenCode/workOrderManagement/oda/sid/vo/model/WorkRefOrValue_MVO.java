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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkRefOrValue_MVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonBackReference
    private Note_MVO note;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_MVO_id")
    @JsonManagedReference
    private List<WorkRelationship_MVO> workRelationship;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_MVO_id")
    @JsonManagedReference
    private List<WorkRefOrValue_MVO> relatedWork;
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
    private AppointmentRef_MVO appointment;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_MVO_id")
    @JsonManagedReference
    private List<WorkPrice_MVO> workPrice;
    @ManyToOne
    @JoinColumn(name = "workSpecification_id")
    @JsonBackReference
    private WorkSpecificationRefOrValue_MVO workSpecification;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_MVO_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue_MVO> place;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private WorkStateType state;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_MVO_id")
    @JsonManagedReference
    private List<WorkforceEmployeeAssignment_MVO> workforceEmployeeAssignment;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_MVO_id")
    @JsonManagedReference
    private List<AgreementRef_MVO> agreement;
    @ManyToOne
    @JoinColumn(name = "quantity_id")
    @JsonBackReference
    private Quantity quantity;
    @ManyToOne
    @JoinColumn(name = "scheduledDuration_id")
    @JsonBackReference
    private Quantity scheduledDuration;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_MVO_id")
    @JsonManagedReference
    private List<RelatedWorkOrderItem_MVO> relatedWorkOrderItem;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "WorkRefOrValue_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> workCharacteristic;
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
    private WorkforceEmployeeTravel_MVO workforceEmployeeTravel;
    private OffsetDateTime completionDate;
    private OffsetDateTime expectedCompletionDate;
    private String workPriority;
    private OffsetDateTime orderDate;
}
