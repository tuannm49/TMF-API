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
public class PolicyActionAtomic_FVO_FVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private PolicyStatement_FVO action;
    @ManyToOne
    @JoinColumn(name = "constraint_id")
    @JsonBackReference
    private PolicyConstraintRefOrValue_FVO constraint;
    private List<String> executedAt;
    @JsonProperty("@type")
    private String type;
}
