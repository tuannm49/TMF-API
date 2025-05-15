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
public class PartyRevSharingPolicyActionVariable implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "policyAction_id")
    @JsonBackReference
    private PolicyActionRef policyAction;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String value;
    @ManyToOne
    @JoinColumn(name = "policyActionVariable_id")
    @JsonBackReference
    private PolicyVariableRef policyActionVariable;
}
