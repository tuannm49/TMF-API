package oda.sid.vo.model;

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
public class SalesLead_MVO implements java.io.Serializable {
    private String description;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private SalesLeadStateType status;
    private OffsetDateTime statusChangeDate;
    private OffsetDateTime referredDate;
    private String statusChangeReason;
    private String salesLeadType;
    private String rating;
    @ManyToOne
    @JoinColumn(name = "priority_id")
    @JsonBackReference
    private SalesLeadPriorityType priority;
    @ManyToOne
    @JoinColumn(name = "estimatedRevenue_id")
    @JsonBackReference
    private Money estimatedRevenue;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @ManyToOne
    @JoinColumn(name = "marketingCampaign_id")
    @JsonBackReference
    private MarketingCampaignRef_MVO marketingCampaign;
    @ManyToOne
    @JoinColumn(name = "marketSegment_id")
    @JsonBackReference
    private MarketSegmentRef_MVO marketSegment;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    @JsonBackReference
    private ChannelRef_MVO channel;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef_MVO productOffering;
    @OneToMany
    @JoinColumn(name = "SalesLead_MVO_id")
    @JsonManagedReference
    private List<RelatedParty_MVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "SalesLead_MVO_id")
    @JsonManagedReference
    private List<ContactMedium_MVO> prospectContact;
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef_MVO productSpecification;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private CategoryRef_MVO category;
    @ManyToOne
    @JoinColumn(name = "salesOpportunity_id")
    @JsonBackReference
    private SalesOpportunityRef_MVO salesOpportunity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRef_MVO product;
    @OneToMany
    @JoinColumn(name = "SalesLead_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    private String name;
}
