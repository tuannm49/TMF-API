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
import oda.sid.vo.model.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Quote_MVO extends Entity implements java.io.Serializable {
    private OffsetDateTime expectedQuoteCompletionDate;
    @OneToMany
    @JoinColumn(name = "Quote_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    @OneToMany
    @JoinColumn(name = "Quote_MVO_id")
    @JsonManagedReference
    private List<ContactMedium_MVO> contactMedium;
    @OneToMany
    @JoinColumn(name = "Quote_MVO_id")
    @JsonManagedReference
    private List<AgreementRef_MVO> agreement;
    private OffsetDateTime requestedQuoteCompletionDate;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private OffsetDateTime expectedFulfillmentStartDate;
    @OneToMany
    @JoinColumn(name = "Quote_MVO_id")
    @JsonManagedReference
    private List<ProductOfferingQualificationRef_MVO> productOfferingQualification;
    private String description;
    @OneToMany
    @JoinColumn(name = "Quote_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalId;
    @OneToMany
    @JoinColumn(name = "Quote_MVO_id")
    @JsonManagedReference
    private List<BillingAccountRef_MVO> billingAccount;
    @OneToMany
    @JoinColumn(name = "Quote_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "Quote_MVO_id")
    @JsonManagedReference
    private List<Authorization_MVO> authorization;
    private OffsetDateTime effectiveQuoteCompletionDate;
    @OneToMany
    @JoinColumn(name = "Quote_MVO_id")
    @JsonManagedReference
    private List<QuotePrice_MVO> quoteTotalPrice;
    @OneToMany
    @JoinColumn(name = "Quote_MVO_id")
    @JsonManagedReference
    private List<QuoteItem_MVO> quoteItem;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private QuoteStateType state;
    private String category;
}
