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
import oda.sid.vo.model.Entity_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerBillOnDemand_FVO extends Entity_FVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "customerBill_id")
    @JsonBackReference
    private CustomerBillRef_FVO customerBill;
    private String lastUpdate;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private CustomerBillOnDemandStateType state;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef_FVO billingAccount;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_FVO relatedParty;
}
