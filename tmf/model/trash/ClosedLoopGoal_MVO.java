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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClosedLoopGoal_MVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "closeLoopGoalSpecification_id")
    @JsonBackReference
    private EntitySpecificationRef_MVO closeLoopGoalSpecification;
    private OffsetDateTime creationdate;
    @ManyToOne
    @JoinColumn(name = "goal_id")
    @JsonBackReference
    private ClosedLoopGoalRef_MVO goal;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime validfor;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String description;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private PartyOrPartyRole_MVO relatedParty;
    private String version;
    @ManyToOne
    @JoinColumn(name = "policy_id")
    @JsonBackReference
    private PolicyRef_MVO policy;
}
