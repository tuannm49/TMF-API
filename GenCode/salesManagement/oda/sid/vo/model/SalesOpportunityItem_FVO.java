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
import java.util.List;
import oda.sid.vo.model.Extensible_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesOpportunityItem_FVO extends Extensible_FVO implements java.io.Serializable {
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
    @OneToMany
    @JoinColumn(name = "SalesOpportunityItem_FVO_id")
    @JsonManagedReference
    private List<SalesTaskRef> salesTask;
    private String rating;
    @ManyToOne
    @JoinColumn(name = "estimatedRevenue_id")
    @JsonBackReference
    private Money estimatedRevenue;
    private String action;
    @OneToMany
    @JoinColumn(name = "SalesOpportunityItem_FVO_id")
    @JsonManagedReference
    private List<SalesLeadRef> salesLead;
    private String id;
    @ManyToOne
    @JoinColumn(name = "priority_id")
    @JsonBackReference
    private SalesOpportunityPriorityType priority;
    @OneToMany
    @JoinColumn(name = "SalesOpportunityItem_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyWithContactInfo> relatedParty;
    @ManyToOne
    @JoinColumn(name = "salesOpportunityItemStatus_id")
    @JsonBackReference
    private SalesOpportunityItemStateType salesOpportunityItemStatus;
}
