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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Work implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private OffsetDateTime completionDate;
    private String description;
    private OffsetDateTime expectedCompletionDate;
    private String name;
    private OffsetDateTime orderDate;
    private Object percentageComplete;
    private String workPriority;
    private String workType;
    @ManyToOne
    @JoinColumn(name = "actualDuration_id")
    @JsonBackReference
    private Quantity actualDuration;
    @OneToMany
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<AgreementRef> agreement;
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonBackReference
    private AppointmentRef appointment;
    @ManyToOne
    @JoinColumn(name = "currentDuration_id")
    @JsonBackReference
    private Quantity currentDuration;
    @ManyToOne
    @JoinColumn(name = "deliveryTimeSlot_id")
    @JsonBackReference
    private TimePeriod deliveryTimeSlot;
    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonBackReference
    private Note note;
    @OneToMany
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue> place;
    @ManyToOne
    @JoinColumn(name = "plannedDuration_id")
    @JsonBackReference
    private Quantity plannedDuration;
    @ManyToOne
    @JoinColumn(name = "quantity_id")
    @JsonBackReference
    private Quantity quantity;
    @OneToMany
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "scheduledDuration_id")
    @JsonBackReference
    private Quantity scheduledDuration;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private WorkStateType state;
    @OneToMany
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<WorkRefOrValue> work;
    @OneToMany
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<Characteristic> workCharacteristic;
    @OneToMany
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<RelatedWorkOrderItem> workOrderItem;
    @OneToMany
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<WorkPrice> workPrice;
    @OneToMany
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<WorkRelationship> workRelationship;
    @ManyToOne
    @JoinColumn(name = "workSpecification_id")
    @JsonBackReference
    private WorkSpecificationRef workSpecification;
    @OneToMany
    @JoinColumn(name = "Work_id")
    @JsonManagedReference
    private List<WorkforceEmployeeAssignment> workforceEmployeeAssignment;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
