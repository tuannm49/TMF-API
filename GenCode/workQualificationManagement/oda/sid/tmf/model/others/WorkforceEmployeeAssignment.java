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
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkforceEmployeeAssignment implements java.io.Serializable {
    @Id
    private String id;
    private String description;
    private String skillType;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private WorkforceEmployeeAssignmentStateType state;
    @OneToMany
    @JoinColumn(name = "WorkforceEmployeeAssignment_id")
    @JsonManagedReference
    private List<TimeSlot> timeSlot;
    @ManyToOne
    @JoinColumn(name = "workforceEmployee_id")
    @JsonBackReference
    private PartyRefOrValue workforceEmployee;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
