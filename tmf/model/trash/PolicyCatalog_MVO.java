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
public class PolicyCatalog_MVO implements java.io.Serializable {
    private String lifecycleState;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<ManagedPolicyAction_MVO> policyAction;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<ManagedPolicyCondition_MVO> policyCondition;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<ManagedPolicyConstraint_MVO> policyConstraint;
    private String description;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<ManagedPolicyOperator_MVO> policyOperator;
    private String version;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<ManagedPolicyEvent_MVO> policyEvent;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<ManagedPolicyExpression_MVO> policyExpression;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<Reference_MVO> policyDomainFilter;
    private String name;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<ManagedPolicyVariable_MVO> policyVariable;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<ManagedPolicy_MVO> policy;
}
