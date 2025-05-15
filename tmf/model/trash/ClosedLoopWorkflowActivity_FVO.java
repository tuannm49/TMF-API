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
public class ClosedLoopWorkflowActivity_FVO implements java.io.Serializable {
    private OffsetDateTime creationdate;
    private OffsetDateTime validfor;
    @OneToMany
    @JoinColumn(name = "ClosedLoopWorkflowActivity_FVO_id")
    @JsonManagedReference
    private List<ActivityRelationship_FVO> activity;
    private OffsetDateTime plannedEnd;
    @JsonProperty("@type")
    private String type;
    private String description;
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
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String actualCost;
}
