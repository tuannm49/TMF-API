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
public class WorkforceEmployeeAssignment implements java.io.Serializable {
    private String skillType;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "WorkforceEmployeeAssignment_id")
    @JsonManagedReference
    private List<TimeSlot> timeSlot;
    @JsonProperty("@type")
    private String type;
    private String description;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private WorkforceEmployeeAssignmentStateType state;
    @ManyToOne
    @JoinColumn(name = "workforceEmployee_id")
    @JsonBackReference
    private PartyRefOrValue workforceEmployee;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
