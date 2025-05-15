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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkforceEmployeeAssignment_MVO implements java.io.Serializable {
    private String description;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private WorkforceEmployeeAssignmentStateType state;
    private String skillType;
    @ManyToOne
    @JoinColumn(name = "workforceEmployee_id")
    @JsonBackReference
    private PartyRefOrValue_MVO workforceEmployee;
    @OneToMany
    @JoinColumn(name = "WorkforceEmployeeAssignment_MVO_id")
    @JsonManagedReference
    private List<TimeSlot_MVO> timeSlot;
}
