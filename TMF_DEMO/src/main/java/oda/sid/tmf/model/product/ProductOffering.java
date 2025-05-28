package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import oda.sid.tmf.model.base.AbstractCatalogEntity;
import oda.sid.tmf.model.base.CatalogEntityId;
import oda.sid.tmf.model.base.EntityRef;
import oda.sid.tmf.model.base.TimePeriod;
import oda.sid.tmf.model.common.CharacteristicSpecification;
import oda.sid.tmf.model.others.ExternalIdentifier;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@IdClass(CatalogEntityId.class)
public class ProductOffering extends AbstractCatalogEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    private Boolean isBundle;
    @OneToOne
    private EntityRef productSpecification;
    private String lifecycleStatus;
    @OneToOne
    private EntityRef serviceCandidate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "channel_ChannelRef")
    private List<EntityRef> channel;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "CharacteristicSpecification")
    private List<CharacteristicSpecification> productOfferingCharacteristic;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "productOffrPrc_ProdOffrPrcRefOrVal")
    private List<EntityRef> productOfferingPrice;
    @OneToOne
    private EntityRef resourceCandidate;
    private String statusReason;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "BundledProductOffering")
    private List<BundledProductOffering> bundledProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "attachment_AttachmentRefOrValue")
    private List<EntityRef> attachment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ExternalIdentifier")
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "place_PlaceRef")
    private List<EntityRef> place;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOfferingTerm")
    private List<ProductOfferingTerm> productOfferingTerm;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "marketSegment_MarketSegmentRef")
    private List<EntityRef> marketSegment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "policy_PolicyRef")
    private List<EntityRef> policy;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecificationCharacteristicValueUse")
    private List<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "agreement_AgreementRef")
    private List<EntityRef> agreement;
    @Embedded
    private TimePeriod validFor;
    private Boolean isSellable;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "AllowedProductAction")
    private List<AllowedProductAction> allowedAction;
    @OneToOne
    private EntityRef serviceLevelAgreement;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "productOffrRel_ProdOffrRel")
    private List<EntityRef> productOfferingRelationship;
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "BundledGroupProductOffering")
    private List<BundledGroupProductOffering> bundledGroupProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "category_CategoryRef")
    private List<EntityRef> category;
}
