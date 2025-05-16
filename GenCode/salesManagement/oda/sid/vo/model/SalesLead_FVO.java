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
public class SalesLead_FVO implements java.io.Serializable {
    private String description;
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
    private MarketingCampaignRef_FVO marketingCampaign;
    @ManyToOne
    @JoinColumn(name = "marketSegment_id")
    @JsonBackReference
    private MarketSegmentRef_FVO marketSegment;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    @JsonBackReference
    private ChannelRef_FVO channel;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef_FVO productOffering;
    @OneToMany
    @JoinColumn(name = "SalesLead_FVO_id")
    @JsonManagedReference
    private List<RelatedParty_FVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "SalesLead_FVO_id")
    @JsonManagedReference
    private List<ContactMedium_FVO> prospectContact;
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef_FVO productSpecification;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private CategoryRef_FVO category;
    @ManyToOne
    @JoinColumn(name = "salesOpportunity_id")
    @JsonBackReference
    private SalesOpportunityRef_FVO salesOpportunity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRef_FVO product;
    @OneToMany
    @JoinColumn(name = "SalesLead_FVO_id")
    @JsonManagedReference
    private List<Note_FVO> note;
    private String name;
}
