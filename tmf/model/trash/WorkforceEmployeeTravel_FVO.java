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
public class WorkforceEmployeeTravel_FVO implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "WorkforceEmployeeTravel_FVO_id")
    @JsonManagedReference
    private List<TimeSlot_FVO> timeSlot;
    private String description;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private WorkforceEmployeeAssignmentStateType state;
    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private GeographicLocationRefOrValue_FVO place;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
