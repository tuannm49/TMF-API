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
public class PolicyCondition_Update implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PolicyCondition_Update_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "PolicyCondition_Update_id")
    @JsonManagedReference
    private List<PolicyConditionStatement> policyConditionStatement;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "PolicyCondition_Update_id")
    @JsonManagedReference
    private List<PolicyCondition> policyCondition;
    @JsonProperty("@type")
    private String type;
    private Boolean isConjustiveNormalForm;
    private String description;
    private OffsetDateTime creationDate;
    private String version;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String policyConditionStrategy;
}
