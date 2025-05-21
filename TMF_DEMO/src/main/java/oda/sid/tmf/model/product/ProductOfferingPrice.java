package oda.sid.tmf.model.product;

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
import oda.sid.tmf.model.base.*;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOfferingPrice extends AbstractEntity implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOfferingPrice_id")
    private List<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_popRelationship", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<ProductOfferingPriceRelationship> popRelationship;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="type", column=@Column(name = "target_type")),@AttributeOverride(name="schemaLocation", column=@Column(name = "target_schemaLocation"))})
    private Quantity unitOfMeasure;
    private String lifecycleStatus;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="type", column=@Column(name = "target_type")),@AttributeOverride(name="schemaLocation", column=@Column(name = "target_schemaLocation"))})
    private TimePeriod validFor;
    private String priceType;
    private String recurringChargePeriodType;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOfferingPrice_id")
    private List<TaxItem> tax;
    private Integer recurringChargePeriodLength;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOfferingPrice_id")
    private List<PricingLogicAlgorithm> pricingLogicAlgorithm;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="type", column=@Column(name = "target_type")),@AttributeOverride(name="schemaLocation", column=@Column(name = "target_schemaLocation"))})
    private Money price;
    private Integer percentage;
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOfferingPrice_id")
    private List<ExternalIdentifier> externalIdentifier;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_place", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<PlaceRef> place;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_bundledPopRelationship", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<BundledProductOfferingPriceRelationship> bundledPopRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOfferingPrice_id")
    private List<ProductOfferingTerm> productOfferingTerm;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_policy", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<PolicyRef> policy;
}
