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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkPrice implements java.io.Serializable {
    private String description;
    private String name;
    private String recurringChargePeriod;
    private String unitOfMeasure;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef billingAccount;
    @ManyToOne
    @JoinColumn(name = "price_id")
    @JsonBackReference
    private Price price;
    @OneToMany
    @JoinColumn(name = "WorkPrice_id")
    @JsonManagedReference
    private List<PriceAlteration> priceAlteration;
    @ManyToOne
    @JoinColumn(name = "priceType_id")
    @JsonBackReference
    private PriceType priceType;
    @ManyToOne
    @JoinColumn(name = "productOfferingPrice_id")
    @JsonBackReference
    private ProductOfferingPriceRef productOfferingPrice;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
