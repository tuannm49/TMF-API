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
public class ClosedLoopGoal implements java.io.Serializable {
    private OffsetDateTime creationdate;
    @ManyToOne
    @JoinColumn(name = "goal_id")
    @JsonBackReference
    private ClosedLoopGoalRef goal;
    private OffsetDateTime validfor;
    @JsonProperty("@type")
    private String type;
    private String description;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private PartyOrPartyRole relatedParty;
    private String version;
    @ManyToOne
    @JoinColumn(name = "closeLoopGoalSpecification_id")
    @JsonBackReference
    private EntitySpecificationRef closeLoopGoalSpecification;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "policy_id")
    @JsonBackReference
    private PolicyRef policy;
}
