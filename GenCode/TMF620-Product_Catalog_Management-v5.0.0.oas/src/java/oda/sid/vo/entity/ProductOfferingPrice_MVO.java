package oda.sid.vo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.util.logging.Logger;
import oda.sid.tmf.entity.others.*;
import oda.sid.tmf.entity.common.*;
import oda.sid.tmf.entity.customer.*;
import oda.sid.tmf.entity.party.*;
import oda.sid.tmf.entity.product.*;
import oda.sid.tmf.entity.resource.*;
import oda.sid.tmf.entity.sale.*;
import oda.sid.tmf.entity.service.*;
import oda.sid.tmf.entity.base.*;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOfferingPrice_MVO extends Entity_MVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private Boolean isBundle;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_MVO_ProductSpecificationCharacteristicValueUse_MVO")
    private List<ProductSpecificationCharacteristicValueUse_MVO> prodSpecCharValueUse;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_MVO_ProductOfferingPriceRelationship_MVO")
    private List<ProductOfferingPriceRelationship_MVO> popRelationship;
    @Embedded
    private Quantity unitOfMeasure;
    private String lifecycleStatus;
    @Embedded
    private TimePeriod validFor;
    private String priceType;
    private String description;
    private String recurringChargePeriodType;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_MVO_TaxItem_MVO")
    private List<TaxItem_MVO> tax;
    private Integer recurringChargePeriodLength;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_MVO_PricingLogicAlgorithm_MVO")
    private List<PricingLogicAlgorithm_MVO> pricingLogicAlgorithm;
    @Embedded
    private Money price;
    private Integer percentage;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_MVO_ExternalIdentifier_MVO")
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_MVO_PlaceRef_MVO")
    private List<PlaceRef_MVO> place;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_MVO_BundledProductOfferingPriceRelationship_MVO")
    private List<BundledProductOfferingPriceRelationship_MVO> bundledPopRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_MVO_ProductOfferingTerm_MVO")
    private List<ProductOfferingTerm_MVO> productOfferingTerm;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_MVO_PolicyRef_MVO")
    private List<PolicyRef_MVO> policy;
}
