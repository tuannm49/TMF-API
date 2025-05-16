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
import oda.sid.vo.model.Account_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyAccount_MVO extends Account_MVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "defaultPaymentMethod_id")
    @JsonBackReference
    private PaymentMethodRef_MVO defaultPaymentMethod;
    @ManyToOne
    @JoinColumn(name = "financialAccount_id")
    @JsonBackReference
    private FinancialAccountRef_MVO financialAccount;
    @OneToMany
    @JoinColumn(name = "PartyAccount_MVO_id")
    @JsonManagedReference
    private List<PaymentPlan_MVO> paymentPlan;
    private String paymentStatus;
    @ManyToOne
    @JoinColumn(name = "billStructure_id")
    @JsonBackReference
    private BillStructure_MVO billStructure;
}
