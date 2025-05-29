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
public class ProductOffering_MVO extends Entity_MVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private Boolean isBundle;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ProductSpecificationRef_MVO productSpecification;
    private String lifecycleStatus;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ServiceCandidateRef_MVO serviceCandidate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MVO_ChannelRef_MVO")
    private List<ChannelRef_MVO> channel;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MVO_CharacteristicSpecification_MVO")
    private List<CharacteristicSpecification_MVO> productOfferingCharacteristic;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MVO_ProductOfferingPriceRefOrValue_MVO")
    private List<EntityRef> productOfferingPrice;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ResourceCandidateRef_MVO resourceCandidate;
    private String statusReason;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MVO_BundledProductOffering_MVO")
    private List<BundledProductOffering_MVO> bundledProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MVO_AttachmentRefOrValue_MVO")
    private List<EntityRef> attachment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MVO_ExternalIdentifier_MVO")
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MVO_PlaceRef_MVO")
    private List<PlaceRef_MVO> place;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MVO_ProductOfferingTerm_MVO")
    private List<ProductOfferingTerm_MVO> productOfferingTerm;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MVO_MarketSegmentRef_MVO")
    private List<MarketSegmentRef_MVO> marketSegment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MVO_PolicyRef_MVO")
    private List<PolicyRef_MVO> policy;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MVO_ProductSpecificationCharacteristicValueUse_MVO")
    private List<ProductSpecificationCharacteristicValueUse_MVO> prodSpecCharValueUse;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MVO_AgreementRef_MVO")
    private List<AgreementRef_MVO> agreement;
    @Embedded
    private TimePeriod validFor;
    private Boolean isSellable;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MVO_AllowedProductAction_MVO")
    private List<AllowedProductAction_MVO> allowedAction;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private SLARef_MVO serviceLevelAgreement;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MVO_ProductOfferingRelationship_MVO")
    private List<ProductOfferingRelationship_MVO> productOfferingRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MVO_BundledGroupProductOffering_MVO")
    private List<BundledGroupProductOffering_MVO> bundledGroupProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductOffering_MVO_CategoryRef_MVO")
    private List<CategoryRef_MVO> category;
}
