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
public class CustomerBill extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CustomerBill_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> billDocument;
    @ManyToOne
    @JoinColumn(name = "taxExcludedAmount_id")
    @JsonBackReference
    private Money taxExcludedAmount;
    @ManyToOne
    @JoinColumn(name = "billingPeriod_id")
    @JsonBackReference
    private TimePeriod billingPeriod;
    @ManyToOne
    @JoinColumn(name = "runType_id")
    @JsonBackReference
    private CustomerBillRunType runType;
    @OneToMany
    @JoinColumn(name = "CustomerBill_id")
    @JsonManagedReference
    private List<TaxItem> taxItem;
    @ManyToOne
    @JoinColumn(name = "financialAccount_id")
    @JsonBackReference
    private FinancialAccountRef financialAccount;
    private OffsetDateTime billDate;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef billingAccount;
    @OneToMany
    @JoinColumn(name = "CustomerBill_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    @ManyToOne
    @JoinColumn(name = "amountDue_id")
    @JsonBackReference
    private Money amountDue;
    @OneToMany
    @JoinColumn(name = "CustomerBill_id")
    @JsonManagedReference
    private List<AppliedPayment> appliedPayment;
    private OffsetDateTime nextBillDate;
    private OffsetDateTime paymentDueDate;
    @ManyToOne
    @JoinColumn(name = "remainingAmount_id")
    @JsonBackReference
    private Money remainingAmount;
    private OffsetDateTime lastUpdate;
    @ManyToOne
    @JoinColumn(name = "paymentMethod_id")
    @JsonBackReference
    private PaymentMethodRef paymentMethod;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private CustomerBillStateType state;
    private String category;
    private String billNo;
    @ManyToOne
    @JoinColumn(name = "billCycle_id")
    @JsonBackReference
    private BillCycleRef billCycle;
    @ManyToOne
    @JoinColumn(name = "taxIncludedAmount_id")
    @JsonBackReference
    private Money taxIncludedAmount;
}
