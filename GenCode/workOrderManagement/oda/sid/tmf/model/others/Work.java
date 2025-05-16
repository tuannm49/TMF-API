package oda.sid.tmf.model.others;

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
import oda.sid.tmf.model.others.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Work extends Entity implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonBackReference
    private Note note;
    @OneToMany
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<WorkRelationship> workRelationship;
    @OneToMany
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<WorkRefOrValue> relatedWork;
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
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<WorkPrice> workPrice;
    @ManyToOne
    @JoinColumn(name = "workSpecification_id")
    @JsonBackReference
    private WorkSpecificationRefOrValue workSpecification;
    @OneToMany
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue> place;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private WorkStateType state;
    @OneToMany
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<WorkforceEmployeeAssignment> workforceEmployeeAssignment;
    @OneToMany
    @JoinColumn(name = "Work_id")
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
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<RelatedWorkOrderItem> relatedWorkOrderItem;
    @OneToMany
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> relatedParty;
    @OneToMany
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<Characteristic> workCharacteristic;
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
    private WorkforceEmployeeTravel workforceEmployeeTravel;
    private OffsetDateTime completionDate;
    private OffsetDateTime expectedCompletionDate;
    private String workPriority;
    private OffsetDateTime orderDate;
}
