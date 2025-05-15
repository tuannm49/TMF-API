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
public class BillingAccount_MVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "defaultPaymentMethod_id")
    @JsonBackReference
    private PaymentMethodRef_MVO defaultPaymentMethod;
    @OneToMany
    @JoinColumn(name = "BillingAccount_MVO_id")
    @JsonManagedReference
    private List<PaymentPlan_MVO> paymentPlan;
    @JsonProperty("@type")
    private String type;
    private String accountType;
    @ManyToOne
    @JoinColumn(name = "billStructure_id")
    @JsonBackReference
    private BillStructure_MVO billStructure;
    private String description;
    @OneToMany
    @JoinColumn(name = "BillingAccount_MVO_id")
    @JsonManagedReference
    private List<AccountRelationship_MVO> accountRelationship;
    @ManyToOne
    @JoinColumn(name = "financialAccount_id")
    @JsonBackReference
    private FinancialAccountRef_MVO financialAccount;
    @OneToMany
    @JoinColumn(name = "BillingAccount_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "BillingAccount_MVO_id")
    @JsonManagedReference
    private List<TaxExemptionCertificate_MVO> taxExemption;
    private String ratingType;
    private OffsetDateTime lastUpdate;
    @OneToMany
    @JoinColumn(name = "BillingAccount_MVO_id")
    @JsonManagedReference
    private List<Contact_MVO> contact;
    private String name;
    @ManyToOne
    @JoinColumn(name = "creditLimit_id")
    @JsonBackReference
    private Money creditLimit;
    private String state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "BillingAccount_MVO_id")
    @JsonManagedReference
    private List<AccountBalance_MVO> accountBalance;
    private String paymentStatus;
}
