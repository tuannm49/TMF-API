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
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.vo.model.Entity_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOfferingPrice_FVO extends Entity_FVO implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    @JsonManagedReference
    private List<ProductSpecificationCharacteristicValueUse_FVO> prodSpecCharValueUse;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    @JsonManagedReference
    private List<ProductOfferingPriceRelationship_FVO> popRelationship;
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
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    @JsonManagedReference
    private List<TaxItem_FVO> tax;
    private Integer recurringChargePeriodLength;
    private String version;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    @JsonManagedReference
    private List<PricingLogicAlgorithm_FVO> pricingLogicAlgorithm;
    @ManyToOne
    @JoinColumn(name = "price_id")
    @JsonBackReference
    private Money price;
    private Object percentage;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    @JsonManagedReference
    private List<PlaceRef_FVO> place;
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
}
