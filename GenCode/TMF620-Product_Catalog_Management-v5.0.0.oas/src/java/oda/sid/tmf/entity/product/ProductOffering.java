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
@IdClass(CatalogEntityId.class)
public class ProductOffering extends AbstractCatalogEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private Boolean isBundle;
    @OneToOne
    private EntityRef productSpecification;
    private String lifecycleStatus;
    @OneToOne
    private EntityRef serviceCandidate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_ChannelRef")
    private List<EntityRef> channel;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_CharacteristicSpecification")
    private List<CharacteristicSpecification> productOfferingCharacteristic;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_ProductOfferingPriceRefOrValue")
    private List<EntityRef> productOfferingPrice;
    @OneToOne
    private EntityRef resourceCandidate;
    private String statusReason;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_BundledProductOffering")
    private List<BundledProductOffering> bundledProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_AttachmentRefOrValue")
    private List<EntityRef> attachment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_ExternalIdentifier")
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_PlaceRef")
    private List<EntityRef> place;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_ProductOfferingTerm")
    private List<ProductOfferingTerm> productOfferingTerm;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MarketSegmentRef")
    private List<EntityRef> marketSegment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_PolicyRef")
    private List<EntityRef> policy;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_ProductSpecificationCharacteristicValueUse")
    private List<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_AgreementRef")
    private List<EntityRef> agreement;
    @Embedded
    private TimePeriod validFor;
    private Boolean isSellable;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_AllowedProductAction")
    private List<AllowedProductAction> allowedAction;
    @OneToOne
    private EntityRef serviceLevelAgreement;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_ProductOfferingRelationship")
    private List<EntityRef> productOfferingRelationship;
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_BundledGroupProductOffering")
    private List<BundledGroupProductOffering> bundledGroupProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_CategoryRef")
    private List<EntityRef> category;
}
