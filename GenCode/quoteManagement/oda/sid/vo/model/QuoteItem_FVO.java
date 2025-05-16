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
public class QuoteItem_FVO extends Extensible implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "QuoteItem_FVO_id")
    @JsonManagedReference
    private List<Note> note;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue_FVO product;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "productOfferingQualificationItem_id")
    @JsonBackReference
    private ProductOfferingQualificationItemRef_FVO productOfferingQualificationItem;
    @OneToMany
    @JoinColumn(name = "QuoteItem_FVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_FVO> attachment;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef productOffering;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private ItemActionType action;
    @OneToMany
    @JoinColumn(name = "QuoteItem_FVO_id")
    @JsonManagedReference
    private List<QuoteItem_FVO> quoteItem;
    @OneToMany
    @JoinColumn(name = "QuoteItem_FVO_id")
    @JsonManagedReference
    private List<AppointmentRef> appointment;
    private String id;
    @OneToMany
    @JoinColumn(name = "QuoteItem_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_FVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "QuoteItem_FVO_id")
    @JsonManagedReference
    private List<QuoteItemRelationship_FVO> quoteItemRelationship;
}
