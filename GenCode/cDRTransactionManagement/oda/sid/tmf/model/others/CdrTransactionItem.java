package oda.sid.tmf.model.others;

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
import oda.sid.tmf.model.others.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CdrTransactionItem extends Extensible implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CdrTransactionItem_id")
    @JsonManagedReference
    private List<Cdr> cdr;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private ItemActionType action;
    @OneToMany
    @JoinColumn(name = "CdrTransactionItem_id")
    @JsonManagedReference
    private List<CustomerBillRef> bill;
    @OneToMany
    @JoinColumn(name = "CdrTransactionItem_id")
    @JsonManagedReference
    private List<PaymentRef> payment;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private CdrTransactionItemStateType state;
    private String id;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef relatedParty;
}
