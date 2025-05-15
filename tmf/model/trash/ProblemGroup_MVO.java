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
public class ProblemGroup_MVO implements java.io.Serializable {
    private String state;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "parentProblem_id")
    @JsonBackReference
    private ServiceProblemRef_MVO parentProblem;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ProblemGroup_MVO_id")
    @JsonManagedReference
    private List<ServiceProblemRef_MVO> childProblem;
}
