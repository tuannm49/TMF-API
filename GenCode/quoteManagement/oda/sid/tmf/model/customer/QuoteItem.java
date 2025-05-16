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
import java.util.List;
import oda.sid.tmf.model.customer.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuoteItem extends Extensible implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "QuoteItem_id")
    @JsonManagedReference
    private List<Note> note;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue product;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef productOffering;
    @OneToMany
    @JoinColumn(name = "QuoteItem_id")
    @JsonManagedReference
    private List<Authorization> quoteItemAuthorization;
    @OneToMany
    @JoinColumn(name = "QuoteItem_id")
    @JsonManagedReference
    private List<AppointmentRef> appointment;
    @OneToMany
    @JoinColumn(name = "QuoteItem_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> relatedParty;
    @ManyToOne
    @JoinColumn(name = "productOfferingQualificationItem_id")
    @JsonBackReference
    private ProductOfferingQualificationItemRef productOfferingQualificationItem;
    @OneToMany
    @JoinColumn(name = "QuoteItem_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private ItemActionType action;
    @OneToMany
    @JoinColumn(name = "QuoteItem_id")
    @JsonManagedReference
    private List<QuoteItem> quoteItem;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private QuoteStateType state;
    private String id;
    @OneToMany
    @JoinColumn(name = "QuoteItem_id")
    @JsonManagedReference
    private List<QuotePrice> quoteItemPrice;
    @OneToMany
    @JoinColumn(name = "QuoteItem_id")
    @JsonManagedReference
    private List<QuoteItemRelationship> quoteItemRelationship;
}
