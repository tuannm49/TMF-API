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
public class AppliedCustomerBillingRate extends Entity implements java.io.Serializable {
    private OffsetDateTime date;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRef product;
    @ManyToOne
    @JoinColumn(name = "taxExcludedAmount_id")
    @JsonBackReference
    private Money taxExcludedAmount;
    @ManyToOne
    @JoinColumn(name = "bill_id")
    @JsonBackReference
    private CustomerBillRef bill;
    private String description;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef billingAccount;
    @OneToMany
    @JoinColumn(name = "AppliedCustomerBillingRate_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @ManyToOne
    @JoinColumn(name = "periodCoverage_id")
    @JsonBackReference
    private TimePeriod periodCoverage;
    private Boolean isBilled;
    private String name;
    @OneToMany
    @JoinColumn(name = "AppliedCustomerBillingRate_id")
    @JsonManagedReference
    private List<AppliedBillingTaxRate> appliedTax;
    @ManyToOne
    @JoinColumn(name = "taxIncludedAmount_id")
    @JsonBackReference
    private Money taxIncludedAmount;
    private String appliedBillingRateType;
}
