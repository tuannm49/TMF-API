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
public class ClosedLoopActivity_FVO implements java.io.Serializable {
    private OffsetDateTime creationdate;
    @ManyToOne
    @JoinColumn(name = "closedLoop_id")
    @JsonBackReference
    private ClosedLoopRef_FVO closedLoop;
    private OffsetDateTime validfor;
    private OffsetDateTime plannedEnd;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "egressPoint_id")
    @JsonBackReference
    private EntityRef_FVO egressPoint;
    private String description;
    @ManyToOne
    @JoinColumn(name = "closedLoopActivitySpecification_id")
    @JsonBackReference
    private EntitySpecificationRef_FVO closedLoopActivitySpecification;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private PartyOrPartyRole_FVO relatedParty;
    private OffsetDateTime plannedStart;
    @ManyToOne
    @JoinColumn(name = "plannedTenure_id")
    @JsonBackReference
    private TimePeriod plannedTenure;
    private String plannedCost;
    @ManyToOne
    @JoinColumn(name = "activityRelationship_id")
    @JsonBackReference
    private EntitySpecificationRef_FVO activityRelationship;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    @ManyToOne
    @JoinColumn(name = "ingressPoint_id")
    @JsonBackReference
    private EntityRef_FVO ingressPoint;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String actualCost;
}
