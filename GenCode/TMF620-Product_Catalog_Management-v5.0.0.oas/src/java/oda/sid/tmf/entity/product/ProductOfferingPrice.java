package oda.sid.tmf.entity.product;

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
public class ProductOfferingPrice extends AbstractEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private Boolean isBundle;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_ProductSpecificationCharacteristicValueUse")
    private List<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_ProductOfferingPriceRelationship")
    private List<EntityRef> popRelationship;
    @Embedded
    private Quantity unitOfMeasure;
    private String lifecycleStatus;
    @Embedded
    private TimePeriod validFor;
    private String priceType;
    private String description;
    private String recurringChargePeriodType;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_TaxItem")
    private List<TaxItem> tax;
    private Integer recurringChargePeriodLength;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_PricingLogicAlgorithm")
    private List<PricingLogicAlgorithm> pricingLogicAlgorithm;
    @Embedded
    private Money price;
    private Integer percentage;
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_ExternalIdentifier")
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_PlaceRef")
    private List<EntityRef> place;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_BundledProductOfferingPriceRelationship")
    private List<EntityRef> bundledPopRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_ProductOfferingTerm")
    private List<ProductOfferingTerm> productOfferingTerm;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingPrice_PolicyRef")
    private List<EntityRef> policy;
}
