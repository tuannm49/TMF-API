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
import oda.sid.vo.model.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuoteItem_MVO extends Extensible implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "QuoteItem_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue_MVO product;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef_MVO productOffering;
    @OneToMany
    @JoinColumn(name = "QuoteItem_MVO_id")
    @JsonManagedReference
    private List<Authorization_MVO> quoteItemAuthorization;
    @OneToMany
    @JoinColumn(name = "QuoteItem_MVO_id")
    @JsonManagedReference
    private List<AppointmentRef_MVO> appointment;
    @OneToMany
    @JoinColumn(name = "QuoteItem_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> relatedParty;
    @ManyToOne
    @JoinColumn(name = "productOfferingQualificationItem_id")
    @JsonBackReference
    private ProductOfferingQualificationItemRef_MVO productOfferingQualificationItem;
    @OneToMany
    @JoinColumn(name = "QuoteItem_MVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_MVO> attachment;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private ItemActionType action;
    @OneToMany
    @JoinColumn(name = "QuoteItem_MVO_id")
    @JsonManagedReference
    private List<QuoteItem_MVO> quoteItem;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private QuoteStateType state;
    private String id;
    @OneToMany
    @JoinColumn(name = "QuoteItem_MVO_id")
    @JsonManagedReference
    private List<QuotePrice_MVO> quoteItemPrice;
    @OneToMany
    @JoinColumn(name = "QuoteItem_MVO_id")
    @JsonManagedReference
    private List<QuoteItemRelationship_MVO> quoteItemRelationship;
}
