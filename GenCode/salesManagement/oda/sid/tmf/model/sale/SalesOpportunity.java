package oda.sid.tmf.model.sale;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesOpportunity implements java.io.Serializable {
    private OffsetDateTime creationDate;
    private String description;
    private String rating;
    private OffsetDateTime referredDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private SalesOpportunityStateType status;
    private OffsetDateTime statusChangeDate;
    private String statusChangeReason;
    private String salesOpportunityType;
    @ManyToOne
    @JoinColumn(name = "estimatedRevenue_id")
    @JsonBackReference
    private Money estimatedRevenue;
    @ManyToOne
    @JoinColumn(name = "priority_id")
    @JsonBackReference
    private SalesOpportunityPriorityType priority;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private CategoryRef category;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    @JsonBackReference
    private ChannelRef channel;
    @ManyToOne
    @JoinColumn(name = "marketSegment_id")
    @JsonBackReference
    private MarketSegmentRef marketSegment;
    @ManyToOne
    @JoinColumn(name = "marketingCampaign_id")
    @JsonBackReference
    private MarketingCampaignRef marketingCampaign;
    @OneToMany
    @JoinColumn(name = "SalesOpportunity_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "SalesOpportunity_id")
    @JsonManagedReference
    private List<AgreementRef> agreement;
    @OneToMany
    @JoinColumn(name = "SalesOpportunity_id")
    @JsonManagedReference
    private List<SalesOpportunityItem> salesOpportunityItem;
    private String name;
}
