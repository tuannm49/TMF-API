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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyActionRelationship_MVO implements java.io.Serializable {
    private Integer priority;
    @ManyToOne
    @JoinColumn(name = "constraint_id")
    @JsonBackReference
    private PolicyConstraintRefOrValue_MVO constraint;
    @ManyToOne
    @JoinColumn(name = "policyActionRefOrValue_id")
    @JsonBackReference
    private PolicyActionRefOrValue_MVO policyActionRefOrValue;
}
