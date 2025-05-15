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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesOpportunityItem_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "SalesOpportunityItem_FVO_id")
    @JsonManagedReference
    private List<Note> note;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue_FVO product;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String rating;
    @ManyToOne
    @JoinColumn(name = "estimatedRevenue_id")
    @JsonBackReference
    private Money estimatedRevenue;
    @OneToMany
    @JoinColumn(name = "SalesOpportunityItem_FVO_id")
    @JsonManagedReference
    private List<SalesLeadRef> salesLead;
    @ManyToOne
    @JoinColumn(name = "priority_id")
    @JsonBackReference
    private SalesOpportunityPriorityType priority;
    @OneToMany
    @JoinColumn(name = "SalesOpportunityItem_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyWithContactInfo> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "SalesOpportunityItem_FVO_id")
    @JsonManagedReference
    private List<SalesTaskRef> salesTask;
    private String action;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "salesOpportunityItemStatus_id")
    @JsonBackReference
    private SalesOpportunityItemStateType salesOpportunityItemStatus;
}
