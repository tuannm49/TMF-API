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
public class PartyRevSharingPolicyConditionVariable_MVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "policyConditionVariable_id")
    @JsonBackReference
    private PolicyVariableRef_MVO policyConditionVariable;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String value;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "policyCondition_id")
    @JsonBackReference
    private PolicyConditionRef_MVO policyCondition;
}
