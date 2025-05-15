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
public class AppliedCustomerBillingRate_FVO implements java.io.Serializable {
    private OffsetDateTime date;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRef product;
    @ManyToOne
    @JoinColumn(name = "taxExcludedAmount_id")
    @JsonBackReference
    private Money taxExcludedAmount;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "bill_id")
    @JsonBackReference
    private CustomerBillRef_FVO bill;
    private String description;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef_FVO billingAccount;
    @OneToMany
    @JoinColumn(name = "AppliedCustomerBillingRate_FVO_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @ManyToOne
    @JoinColumn(name = "periodCoverage_id")
    @JsonBackReference
    private TimePeriod periodCoverage;
    private Boolean isBilled;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "AppliedCustomerBillingRate_FVO_id")
    @JsonManagedReference
    private List<AppliedBillingTaxRate> appliedTax;
    @ManyToOne
    @JoinColumn(name = "taxIncludedAmount_id")
    @JsonBackReference
    private Money taxIncludedAmount;
    private String appliedBillingRateType;
}
