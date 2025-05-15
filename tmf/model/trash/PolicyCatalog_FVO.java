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
public class PolicyCatalog_FVO implements java.io.Serializable {
    private String lifecycleState;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<Note_FVO> note;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<ManagedPolicyAction_FVO> policyAction;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<ManagedPolicyCondition_FVO> policyCondition;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<ManagedPolicyConstraint_FVO> policyConstraint;
    private String description;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<ManagedPolicyOperator_FVO> policyOperator;
    private String version;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<ManagedPolicyEvent_FVO> policyEvent;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<ManagedPolicyExpression_FVO> policyExpression;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<Reference_FVO_FVO_FVO_FVO_FVO> policyDomainFilter;
    private String name;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<ManagedPolicyVariable_FVO> policyVariable;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<ManagedPolicy_FVO> policy;
}
