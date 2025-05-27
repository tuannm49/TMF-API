package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import oda.sid.tmf.model.base.*;
import oda.sid.tmf.model.common.PlaceRef;
import oda.sid.tmf.model.customer.TaxItem;
import oda.sid.tmf.model.others.ExternalIdentifier;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOfferingPrice extends AbstractEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    private Boolean isBundle;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffrPrc_prodSpecCharValUse")
    private List<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffrPrc_popRel")
    private List<ProductOfferingPriceRelationship> popRelationship;
    @Embedded
    private Quantity unitOfMeasure;
    private String lifecycleStatus;
    @Embedded
    private TimePeriod validFor;
    private String priceType;
    private String description;
    private String recurringChargePeriodType;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffrPrc_tax")
    private List<TaxItem> tax;
    private Integer recurringChargePeriodLength;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffrPrc")
    private List<PricingLogicAlgorithm> pricingLogicAlgorithm;
    @Embedded
    private Money price;
    private Integer percentage;
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffrPrc_externalIdentifier")
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffrPrc_place")
    private List<PlaceRef> place;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffrPrc_bundledPopRel")
    private List<BundledProductOfferingPriceRelationship> bundledPopRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffrPrc_productOffrTerm")
    private List<ProductOfferingTerm> productOfferingTerm;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffrPrc_policy")
    private List<PolicyRef> policy;
}
