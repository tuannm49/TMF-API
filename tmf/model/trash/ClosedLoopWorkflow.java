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
public class ClosedLoopWorkflow implements java.io.Serializable {
    private OffsetDateTime creationdate;
    @ManyToOne
    @JoinColumn(name = "closedLoop_id")
    @JsonBackReference
    private ClosedLoopRef closedLoop;
    private OffsetDateTime validfor;
    @ManyToOne
    @JoinColumn(name = "startedBy_id")
    @JsonBackReference
    private Trigger startedBy;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "egressPoint_id")
    @JsonBackReference
    private EntityRef egressPoint;
    private String description;
    @ManyToOne
    @JoinColumn(name = "endedBy_id")
    @JsonBackReference
    private Trigger endedBy;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private PartyOrPartyRole relatedParty;
    @ManyToOne
    @JoinColumn(name = "closedLoopWorkflowActivity_id")
    @JsonBackReference
    private ClosedLoopWorkflowActivityRef closedLoopWorkflowActivity;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    @ManyToOne
    @JoinColumn(name = "ingressPoint_id")
    @JsonBackReference
    private EntityRef ingressPoint;
    @ManyToOne
    @JoinColumn(name = "closedLoopWorkflowPriority_id")
    @JsonBackReference
    private ClosedLoopWorkflowPriorityRef closedLoopWorkflowPriority;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
