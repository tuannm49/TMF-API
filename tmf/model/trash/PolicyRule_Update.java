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
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyRule_Update implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PolicyRule_Update_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "PolicyRule_Update_id")
    @JsonManagedReference
    private List<PolicyActionRef> policyAction;
    @ManyToOne
    @JoinColumn(name = "policyCondition_id")
    @JsonBackReference
    private PolicyConditionRef policyCondition;
    @JsonProperty("@type")
    private String type;
    private Boolean isConjustiveNormalForm;
    private String description;
    private Integer sequencedAction;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "PolicyRule_Update_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private String version;
    @ManyToOne
    @JoinColumn(name = "policyEvent_id")
    @JsonBackReference
    private PolicyEventRef policyEvent;
    private Integer sequencedValue;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    @OneToMany
    @JoinColumn(name = "PolicyRule_Update_id")
    @JsonManagedReference
    private List<PolicyDomainRef> policyDomain;
    private String executionStrategy;
    private String state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
