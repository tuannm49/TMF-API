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
public class PolicyActionComposite_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PolicyActionComposite_MVO_id")
    @JsonManagedReference
    private List<PolicyActionRelationship_MVO> action;
    @ManyToOne
    @JoinColumn(name = "constraint_id")
    @JsonBackReference
    private PolicyConstraintRefOrValue_MVO constraint;
    private List<String> executedAt;
    @JsonProperty("@type")
    private String type;
}
