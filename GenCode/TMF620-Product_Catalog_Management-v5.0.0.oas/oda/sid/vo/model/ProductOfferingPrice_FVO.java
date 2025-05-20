package oda.sid.vo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import java.util.List;
import java.util.Date;
import oda.sid.tmf.model.others.*;
import oda.sid.tmf.model.common.*;
import oda.sid.tmf.model.customer.*;
import oda.sid.tmf.model.party.*;
import oda.sid.tmf.model.product.*;
import oda.sid.tmf.model.resource.*;
import oda.sid.tmf.model.sale.*;
import oda.sid.tmf.model.service.*;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOfferingPrice_FVO extends Entity_FVO implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    private List<ProductSpecificationCharacteristicValueUse_FVO> prodSpecCharValueUse;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    private List<ProductOfferingPriceRelationship_FVO> popRelationship;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="type", column=@Column(name = "target_type")),@AttributeOverride(name="schemaLocation", column=@Column(name = "target_schemaLocation"))})
    private Quantity unitOfMeasure;
    private String lifecycleStatus;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="type", column=@Column(name = "target_type")),@AttributeOverride(name="schemaLocation", column=@Column(name = "target_schemaLocation"))})
    private TimePeriod validFor;
    private String priceType;
    private String description;
    private String recurringChargePeriodType;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    private List<TaxItem_FVO> tax;
    private Integer recurringChargePeriodLength;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    private List<PricingLogicAlgorithm_FVO> pricingLogicAlgorithm;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="type", column=@Column(name = "target_type")),@AttributeOverride(name="schemaLocation", column=@Column(name = "target_schemaLocation"))})
    private Money price;
    private Integer percentage;
    private Date lastUpdate;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    private List<PlaceRef_FVO> place;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    private List<BundledProductOfferingPriceRelationship_FVO> bundledPopRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    private List<ProductOfferingTerm_FVO> productOfferingTerm;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOfferingPrice_FVO_id")
    private List<PolicyRef_FVO> policy;
}
