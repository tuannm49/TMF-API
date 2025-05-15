package com.example.Product;

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
public class ProductOfferingPrice_allOf implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<ProductOfferingPriceRelationship> popRelationship;
    @ManyToOne
    @JoinColumn(name = "unitOfMeasure_id")
    @JsonBackReference
    private Quantity unitOfMeasure;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String priceType;
    private String description;
    private String recurringChargePeriodType;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<TaxItem> tax;
    private Integer recurringChargePeriodLength;
    private String version;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<PricingLogicAlgorithm> pricingLogicAlgorithm;
    @ManyToOne
    @JoinColumn(name = "price_id")
    @JsonBackReference
    private Money price;
    private Object percentage;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<PlaceRef> place;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<BundledProductOfferingPriceRelationship> bundledPopRelationship;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<ProductOfferingTerm> productOfferingTerm;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_allOf_id")
    @JsonManagedReference
    private List<PolicyRef> policy;
}
