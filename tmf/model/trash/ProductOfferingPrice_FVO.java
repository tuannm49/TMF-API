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
public class ProductOfferingPrice_FVO implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    @JsonManagedReference
    private List<ProductOfferingPriceRelationship_FVO> popRelationship;
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
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    @JsonManagedReference
    private List<PlaceRef_FVO> place;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    @JsonManagedReference
    private List<BundledProductOfferingPriceRelationship_FVO> bundledPopRelationship;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    @JsonManagedReference
    private List<ProductOfferingTerm_FVO> productOfferingTerm;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    @JsonManagedReference
    private List<PolicyRef_FVO> policy;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    @JsonManagedReference
    private List<ProductSpecificationCharacteristicValueUse_FVO> prodSpecCharValueUse;
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
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    @JsonManagedReference
    private List<TaxItem_FVO> tax;
    private String version;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    @JsonManagedReference
    private List<PricingLogicAlgorithm_FVO> pricingLogicAlgorithm;
    private OffsetDateTime lastUpdate;
    private String name;
}
