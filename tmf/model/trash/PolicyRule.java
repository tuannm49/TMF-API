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
public class PolicyRule implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PolicyRule_id")
    @JsonManagedReference
    private List<PolicyEventRelationship> policyEventRelationship;
    @OneToMany
    @JoinColumn(name = "PolicyRule_id")
    @JsonManagedReference
    private List<Reference> policyDomainRef;
    private String targetPolicyEffect;
    private String sequencedActions;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "policyConditionRefOrValue_id")
    @JsonBackReference
    private PolicyConditionRefOrValue policyConditionRefOrValue;
    private Integer priority;
    private String actionExecutionStrategy;
    @OneToMany
    @JoinColumn(name = "PolicyRule_id")
    @JsonManagedReference
    private List<PolicyActionRelationship> policyActionRelationship;
}
