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
import java.util.List;
import oda.sid.vo.model.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkforceEmployeeAssignment_FVO extends Extensible implements java.io.Serializable {
    private String description;
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private WorkforceEmployeeAssignmentStateType state;
    private String skillType;
    @ManyToOne
    @JoinColumn(name = "workforceEmployee_id")
    @JsonBackReference
    private PartyRefOrValue_FVO workforceEmployee;
    @OneToMany
    @JoinColumn(name = "WorkforceEmployeeAssignment_FVO_id")
    @JsonManagedReference
    private List<TimeSlot_FVO> timeSlot;
}
