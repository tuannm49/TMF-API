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
public class PolicyActionOperation implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PolicyActionOperation_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "PolicyActionOperation_id")
    @JsonManagedReference
    private List<PolicyAction> policyAction;
    private String actionStrategy;
    @ManyToOne
    @JoinColumn(name = "actionValue_id")
    @JsonBackReference
    private PolicyActionValue actionValue;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String description;
    private OffsetDateTime creationDate;
    private String version;
    private String filter;
    private String path;
    @OneToMany
    @JoinColumn(name = "PolicyActionOperation_id")
    @JsonManagedReference
    private List<PolicyConditionRef> actionCondition;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    @Id
    private String id;
    private String href;
    private Integer actionSequence;
    private String fields;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String operation;
}
