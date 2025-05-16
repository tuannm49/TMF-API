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
public class ProductOfferingPrice implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_id")
    @JsonManagedReference
    private List<ProductOfferingPriceRelationship> popRelationship;
    private String lifecycleStatus;
    @JsonProperty("@type")
    private String type;
    private String description;
    private String recurringChargePeriodType;
    private Integer recurringChargePeriodLength;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "price_id")
    @JsonBackReference
    private Money price;
    private Object percentage;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    private String href;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_id")
    @JsonManagedReference
    private List<PlaceRef> place;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_id")
    @JsonManagedReference
    private List<BundledProductOfferingPriceRelationship> bundledPopRelationship;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_id")
    @JsonManagedReference
    private List<ProductOfferingTerm> productOfferingTerm;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_id")
    @JsonManagedReference
    private List<PolicyRef> policy;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_id")
    @JsonManagedReference
    private List<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse;
    @ManyToOne
    @JoinColumn(name = "unitOfMeasure_id")
    @JsonBackReference
    private Quantity unitOfMeasure;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String priceType;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_id")
    @JsonManagedReference
    private List<TaxItem> tax;
    private String version;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_id")
    @JsonManagedReference
    private List<PricingLogicAlgorithm> pricingLogicAlgorithm;
    private OffsetDateTime lastUpdate;
    private String name;
}
