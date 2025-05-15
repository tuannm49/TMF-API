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
public class PolicyCatalog implements java.io.Serializable {
    private String lifecycleState;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<ManagedPolicyAction> policyAction;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<ManagedPolicyCondition> policyCondition;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<ManagedPolicyConstraint> policyConstraint;
    private String description;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<ManagedPolicyOperator> policyOperator;
    private String version;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<ManagedPolicyEvent> policyEvent;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<ManagedPolicyExpression> policyExpression;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<Reference> policyDomainFilter;
    private String name;
    private String href;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<ManagedPolicyVariable> policyVariable;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<ManagedPolicy> policy;
}
