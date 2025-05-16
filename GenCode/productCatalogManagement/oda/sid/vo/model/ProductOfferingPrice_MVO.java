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
import oda.sid.vo.model.Entity_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOfferingPrice_MVO extends Entity_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_MVO_id")
    @JsonManagedReference
    private List<ProductSpecificationCharacteristicValueUse_MVO> prodSpecCharValueUse;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_MVO_id")
    @JsonManagedReference
    private List<ProductOfferingPriceRelationship_MVO> popRelationship;
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
    @JoinColumn(name = "ProductOfferingPrice_MVO_id")
    @JsonManagedReference
    private List<TaxItem_MVO> tax;
    private Integer recurringChargePeriodLength;
    private String version;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_MVO_id")
    @JsonManagedReference
    private List<PricingLogicAlgorithm_MVO> pricingLogicAlgorithm;
    @ManyToOne
    @JoinColumn(name = "price_id")
    @JsonBackReference
    private Money price;
    private Object percentage;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_MVO_id")
    @JsonManagedReference
    private List<PlaceRef_MVO> place;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_MVO_id")
    @JsonManagedReference
    private List<BundledProductOfferingPriceRelationship_MVO> bundledPopRelationship;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_MVO_id")
    @JsonManagedReference
    private List<ProductOfferingTerm_MVO> productOfferingTerm;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_MVO_id")
    @JsonManagedReference
    private List<PolicyRef_MVO> policy;
}
