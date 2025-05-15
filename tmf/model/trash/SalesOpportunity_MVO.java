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
public class SalesOpportunity_MVO implements java.io.Serializable {
    private String statusChangeReason;
    @OneToMany
    @JoinColumn(name = "SalesOpportunity_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    @OneToMany
    @JoinColumn(name = "SalesOpportunity_MVO_id")
    @JsonManagedReference
    private List<AgreementRef_MVO> agreement;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String rating;
    @ManyToOne
    @JoinColumn(name = "estimatedRevenue_id")
    @JsonBackReference
    private Money estimatedRevenue;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    @JsonBackReference
    private ChannelRef_MVO channel;
    private String description;
    private String salesOpportunityType;
    @ManyToOne
    @JoinColumn(name = "priority_id")
    @JsonBackReference
    private SalesOpportunityPriorityType priority;
    @ManyToOne
    @JoinColumn(name = "marketingCampaign_id")
    @JsonBackReference
    private MarketingCampaignRef_MVO marketingCampaign;
    private OffsetDateTime statusChangeDate;
    private String name;
    @OneToMany
    @JoinColumn(name = "SalesOpportunity_MVO_id")
    @JsonManagedReference
    private List<SalesOpportunityItem_MVO> salesOpportunityItem;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private CategoryRef_MVO category;
    private OffsetDateTime referredDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private SalesOpportunityStateType status;
    @ManyToOne
    @JoinColumn(name = "marketSegment_id")
    @JsonBackReference
    private MarketSegmentRef_MVO marketSegment;
}
