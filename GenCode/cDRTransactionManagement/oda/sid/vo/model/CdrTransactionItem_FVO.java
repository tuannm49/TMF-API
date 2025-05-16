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
public class CdrTransactionItem_FVO extends Extensible_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CdrTransactionItem_FVO_id")
    @JsonManagedReference
    private List<Cdr_FVO> cdr;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private ItemActionType action;
    @OneToMany
    @JoinColumn(name = "CdrTransactionItem_FVO_id")
    @JsonManagedReference
    private List<CustomerBillRef_FVO> bill;
    @OneToMany
    @JoinColumn(name = "CdrTransactionItem_FVO_id")
    @JsonManagedReference
    private List<PaymentRef_FVO> payment;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private CdrTransactionItemStateType state;
    private String id;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_FVO relatedParty;
}
