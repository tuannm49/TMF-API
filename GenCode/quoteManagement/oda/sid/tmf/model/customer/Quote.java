package oda.sid.tmf.model.customer;

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
import oda.sid.tmf.model.customer.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Quote extends Entity implements java.io.Serializable {
    private OffsetDateTime expectedQuoteCompletionDate;
    @OneToMany
    @JoinColumn(name = "Quote_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "Quote_id")
    @JsonManagedReference
    private List<ContactMedium> contactMedium;
    @OneToMany
    @JoinColumn(name = "Quote_id")
    @JsonManagedReference
    private List<AgreementRef> agreement;
    private OffsetDateTime requestedQuoteCompletionDate;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private OffsetDateTime expectedFulfillmentStartDate;
    @OneToMany
    @JoinColumn(name = "Quote_id")
    @JsonManagedReference
    private List<ProductOfferingQualificationRef> productOfferingQualification;
    private String description;
    @OneToMany
    @JoinColumn(name = "Quote_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalId;
    @OneToMany
    @JoinColumn(name = "Quote_id")
    @JsonManagedReference
    private List<BillingAccountRef> billingAccount;
    @OneToMany
    @JoinColumn(name = "Quote_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> relatedParty;
    private OffsetDateTime creationDate;
    private String version;
    @OneToMany
    @JoinColumn(name = "Quote_id")
    @JsonManagedReference
    private List<Authorization> authorization;
    private OffsetDateTime effectiveQuoteCompletionDate;
    @OneToMany
    @JoinColumn(name = "Quote_id")
    @JsonManagedReference
    private List<QuotePrice> quoteTotalPrice;
    @OneToMany
    @JoinColumn(name = "Quote_id")
    @JsonManagedReference
    private List<QuoteItem> quoteItem;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private QuoteStateType state;
    private String category;
    private Boolean instantSyncQuote;
}
