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
public class PolicySet_FVO_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PolicySet_FVO_FVO_id")
    @JsonManagedReference
    private List<PolicyEventRelationship_FVO> policyEventRelationship;
    @OneToMany
    @JoinColumn(name = "PolicySet_FVO_FVO_id")
    @JsonManagedReference
    private List<Reference_FVO_FVO> policyDomainRef;
    private String combiningAlgorithm;
    private String sequencedActions;
    @JsonProperty("@type")
    private String type;
    private Integer priority;
    private String actionExecutionStrategy;
    @OneToMany
    @JoinColumn(name = "PolicySet_FVO_FVO_id")
    @JsonManagedReference
    private List<PolicyActionRelationship_FVO> policyActionRelationship;
    @OneToMany
    @JoinColumn(name = "PolicySet_FVO_FVO_id")
    @JsonManagedReference
    private List<PolicyRelationship_FVO> policyRelationship;
}
