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
public class ClosedLoop implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private OffsetDateTime plannedEnd;
    @ManyToOne
    @JoinColumn(name = "startedBy_id")
    @JsonBackReference
    private Trigger startedBy;
    @ManyToOne
    @JoinColumn(name = "closedLoopGoal_id")
    @JsonBackReference
    private ClosedLoopGoalRef closedLoopGoal;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "closedLoopSpecification_id")
    @JsonBackReference
    private EntitySpecificationRef closedLoopSpecification;
    @ManyToOne
    @JoinColumn(name = "egressPoint_id")
    @JsonBackReference
    private EntityRef egressPoint;
    private String description;
    @OneToMany
    @JoinColumn(name = "ClosedLoop_id")
    @JsonManagedReference
    private List<Trigger> errorEvent;
    @ManyToOne
    @JoinColumn(name = "endedBy_id")
    @JsonBackReference
    private Trigger endedBy;
    private OffsetDateTime creationDate;
    private OffsetDateTime plannedStart;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private PartyOrPartyRole relatedParty;
    @OneToMany
    @JoinColumn(name = "ClosedLoop_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @OneToMany
    @JoinColumn(name = "ClosedLoop_id")
    @JsonManagedReference
    private List<EntityRelationship> closedLoopRelationship;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "closedLoopStatus_id")
    @JsonBackReference
    private ClosedLoopStatusType closedLoopStatus;
    private String name;
    @ManyToOne
    @JoinColumn(name = "ingressPoint_id")
    @JsonBackReference
    private EntityRef ingressPoint;
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
