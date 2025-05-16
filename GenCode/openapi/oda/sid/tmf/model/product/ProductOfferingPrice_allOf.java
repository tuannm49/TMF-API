package oda.sid.tmf.model.product;

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
public class ProductOfferingPrice_allOf implements java.io.Serializable {
    private String description;
    private String version;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @ManyToOne
    @JoinColumn(name = "unitOfMeasure_id")
    @JsonBackReference
    private Quantity unitOfMeasure;
    private String recurringChargePeriodType;
    private Integer recurringChargePeriodLength;
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "price_id")
    @JsonBackReference
    private Money price;
    private Object percentage;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<BundledProductOfferingPriceRelationship> bundledPopRelationship;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<ProductOfferingPriceRelationship> popRelationship;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<ProductOfferingTerm> productOfferingTerm;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<PlaceRef> place;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<PolicyRef> policy;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<PricingLogicAlgorithm> pricingLogicAlgorithm;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<TaxItem> tax;
    private String name;
    private String priceType;
    private OffsetDateTime lastUpdate;
    private String lifecycleStatus;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
}
