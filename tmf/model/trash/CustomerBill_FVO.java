package com.example.trash;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerBill_FVO implements java.io.Serializable {
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "runType_id")
    @JsonBackReference
    private CustomerBillRunType runType;
    @OneToMany
    @JoinColumn(name = "CustomerBill_FVO_id")
    @JsonManagedReference
    private List<TaxItem> taxItem;
    @ManyToOne
    @JoinColumn(name = "financialAccount_id")
    @JsonBackReference
    private FinancialAccountRef financialAccount;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef_FVO billingAccount;
    @ManyToOne
    @JoinColumn(name = "remainingAmount_id")
    @JsonBackReference
    private Money remainingAmount;
    @JsonProperty("@baseType")
    private String baseType;
    private String href;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private CustomerBillStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String billNo;
    @OneToMany
    @JoinColumn(name = "CustomerBill_FVO_id")
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
    private OffsetDateTime billDate;
    @OneToMany
    @JoinColumn(name = "CustomerBill_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    @ManyToOne
    @JoinColumn(name = "amountDue_id")
    @JsonBackReference
    private Money amountDue;
    @OneToMany
    @JoinColumn(name = "CustomerBill_FVO_id")
    @JsonManagedReference
    private List<AppliedPayment> appliedPayment;
    private OffsetDateTime nextBillDate;
    private OffsetDateTime paymentDueDate;
    private OffsetDateTime lastUpdate;
    @ManyToOne
    @JoinColumn(name = "paymentMethod_id")
    @JsonBackReference
    private PaymentMethodRef paymentMethod;
    private String category;
    @ManyToOne
    @JoinColumn(name = "billCycle_id")
    @JsonBackReference
    private BillCycleRef billCycle;
    @ManyToOne
    @JoinColumn(name = "taxIncludedAmount_id")
    @JsonBackReference
    private Money taxIncludedAmount;
}
