package oda.sid.vo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.util.logging.Logger;
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
public class ProductOffering_MVO extends Entity_MVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    private Boolean isBundle;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ProductSpecificationRef_MVO productSpecification;
    private String lifecycleStatus;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ServiceCandidateRef_MVO serviceCandidate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_MVO_channel")
    private List<ChannelRef_MVO> channel;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_MVO_productOffrChar")
    private List<CharacteristicSpecification_MVO> productOfferingCharacteristic;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_MVO_productOffrPrc")
    private List<ProductOfferingPriceRefOrValue_MVO> productOfferingPrice;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ResourceCandidateRef_MVO resourceCandidate;
    private String statusReason;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_MVO_bundledProdOffr")
    private List<BundledProductOffering_MVO> bundledProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_MVO_attachment")
    private List<AttachmentRefOrValue_MVO> attachment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_MVO")
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_MVO_place")
    private List<PlaceRef_MVO> place;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_MVO_productOffrTerm")
    private List<ProductOfferingTerm_MVO> productOfferingTerm;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_MVO_marketSegment")
    private List<MarketSegmentRef_MVO> marketSegment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_MVO_policy")
    private List<PolicyRef_MVO> policy;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_MVO")
    private List<ProductSpecificationCharacteristicValueUse_MVO> prodSpecCharValueUse;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_MVO_agreement")
    private List<AgreementRef_MVO> agreement;
    @Embedded
    private TimePeriod validFor;
    private Boolean isSellable;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_MVO_allowedAction")
    private List<AllowedProductAction_MVO> allowedAction;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private SLARef_MVO serviceLevelAgreement;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_MVO_productOffrRel")
    private List<ProductOfferingRelationship_MVO> productOfferingRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_MVO")
    private List<BundledGroupProductOffering_MVO> bundledGroupProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_MVO_category")
    private List<CategoryRef_MVO> category;
}
