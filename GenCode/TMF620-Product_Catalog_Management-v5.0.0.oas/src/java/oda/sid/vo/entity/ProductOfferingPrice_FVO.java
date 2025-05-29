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
public class ProductOfferingPrice_FVO extends Entity_FVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private Boolean isBundle;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_FVO_ProductSpecificationCharacteristicValueUse_FVO")
    private List<ProductSpecificationCharacteristicValueUse_FVO> prodSpecCharValueUse;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_FVO_ProductOfferingPriceRelationship_FVO")
    private List<ProductOfferingPriceRelationship_FVO> popRelationship;
    @Embedded
    private Quantity unitOfMeasure;
    private String lifecycleStatus;
    @Embedded
    private TimePeriod validFor;
    private String priceType;
    private String description;
    private String recurringChargePeriodType;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_FVO_TaxItem_FVO")
    private List<TaxItem_FVO> tax;
    private Integer recurringChargePeriodLength;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_FVO_PricingLogicAlgorithm_FVO")
    private List<PricingLogicAlgorithm_FVO> pricingLogicAlgorithm;
    @Embedded
    private Money price;
    private Integer percentage;
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_FVO_ExternalIdentifier_FVO")
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_FVO_PlaceRef_FVO")
    private List<PlaceRef_FVO> place;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_FVO_BundledProductOfferingPriceRelationship_FVO")
    private List<BundledProductOfferingPriceRelationship_FVO> bundledPopRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_FVO_ProductOfferingTerm_FVO")
    private List<ProductOfferingTerm_FVO> productOfferingTerm;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_FVO_PolicyRef_FVO")
    private List<PolicyRef_FVO> policy;
}
