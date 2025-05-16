package oda.sid.vo.model;

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
public class ProductOfferingPrice_MVO_allOf implements java.io.Serializable {
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
    @JoinColumn(name = "ProductOfferingPrice_MVO_allOf_id")
    @JsonManagedReference
    private List<BundledProductOfferingPriceRelationship_MVO> bundledPopRelationship;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_MVO_allOf_id")
    @JsonManagedReference
    private List<ProductOfferingPriceRelationship_MVO> popRelationship;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_MVO_allOf_id")
    @JsonManagedReference
    private List<ProductSpecificationCharacteristicValueUse_MVO> prodSpecCharValueUse;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_MVO_allOf_id")
    @JsonManagedReference
    private List<ProductOfferingTerm_MVO> productOfferingTerm;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_MVO_allOf_id")
    @JsonManagedReference
    private List<PlaceRef_MVO> place;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_MVO_allOf_id")
    @JsonManagedReference
    private List<PolicyRef_MVO> policy;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_MVO_allOf_id")
    @JsonManagedReference
    private List<PricingLogicAlgorithm_MVO> pricingLogicAlgorithm;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_MVO_allOf_id")
    @JsonManagedReference
    private List<TaxItem_MVO> tax;
    private String name;
    private String priceType;
    private String lifecycleStatus;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_MVO_allOf_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
}
