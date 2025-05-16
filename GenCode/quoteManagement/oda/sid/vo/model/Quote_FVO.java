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
public class Quote_FVO extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Quote_FVO_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "Quote_FVO_id")
    @JsonManagedReference
    private List<ContactMedium> contactMedium;
    @OneToMany
    @JoinColumn(name = "Quote_FVO_id")
    @JsonManagedReference
    private List<AgreementRef> agreement;
    private OffsetDateTime requestedQuoteCompletionDate;
    private OffsetDateTime expectedFulfillmentStartDate;
    @OneToMany
    @JoinColumn(name = "Quote_FVO_id")
    @JsonManagedReference
    private List<ProductOfferingQualificationRef> productOfferingQualification;
    private String description;
    @OneToMany
    @JoinColumn(name = "Quote_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalId;
    @OneToMany
    @JoinColumn(name = "Quote_FVO_id")
    @JsonManagedReference
    private List<BillingAccountRef> billingAccount;
    @OneToMany
    @JoinColumn(name = "Quote_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_FVO> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "Quote_FVO_id")
    @JsonManagedReference
    private List<QuoteItem_FVO> quoteItem;
    private String category;
    private Boolean instantSyncQuote;
}
