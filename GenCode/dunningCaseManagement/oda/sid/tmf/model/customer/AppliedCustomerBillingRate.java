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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppliedCustomerBillingRate implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private String appliedBillingRateType;
    private OffsetDateTime date;
    private String description;
    private Boolean isBilled;
    private String name;
    @OneToMany
    @JoinColumn(name = "AppliedCustomerBillingRate_id")
    @JsonManagedReference
    private List<AppliedBillingTaxRate> appliedTax;
    @ManyToOne
    @JoinColumn(name = "bill_id")
    @JsonBackReference
    private CustomerBillRef bill;
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
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRef product;
    @ManyToOne
    @JoinColumn(name = "taxExcludedAmount_id")
    @JsonBackReference
    private Money taxExcludedAmount;
    @ManyToOne
    @JoinColumn(name = "taxIncludedAmount_id")
    @JsonBackReference
    private Money taxIncludedAmount;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
