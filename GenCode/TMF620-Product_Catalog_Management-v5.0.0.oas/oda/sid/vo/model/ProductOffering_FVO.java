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
public class ProductOffering_FVO extends Entity_FVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    private Boolean isBundle;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ProductSpecificationRef_FVO productSpecification;
    private String lifecycleStatus;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ServiceCandidateRef_FVO serviceCandidate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_FVO_channel")
    private List<ChannelRef_FVO> channel;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_FVO_productOffrChar")
    private List<CharacteristicSpecification_FVO> productOfferingCharacteristic;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_FVO_productOffrPrc")
    private List<ProductOfferingPriceRefOrValue_FVO> productOfferingPrice;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ResourceCandidateRef_FVO resourceCandidate;
    private String statusReason;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_FVO_bundledProdOffr")
    private List<BundledProductOffering_FVO> bundledProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_FVO_attachment")
    private List<AttachmentRefOrValue_FVO> attachment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_FVO")
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_FVO_place")
    private List<PlaceRef_FVO> place;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_FVO_productOffrTerm")
    private List<ProductOfferingTerm_FVO> productOfferingTerm;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_FVO_marketSegment")
    private List<MarketSegmentRef_FVO> marketSegment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_FVO_policy")
    private List<PolicyRef_FVO> policy;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_FVO")
    private List<ProductSpecificationCharacteristicValueUse_FVO> prodSpecCharValueUse;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_FVO_agreement")
    private List<AgreementRef_FVO> agreement;
    @Embedded
    private TimePeriod validFor;
    private Boolean isSellable;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_FVO_allowedAction")
    private List<AllowedProductAction_FVO> allowedAction;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private SLARef_FVO serviceLevelAgreement;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_FVO_productOffrRel")
    private List<ProductOfferingRelationship_FVO> productOfferingRelationship;
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_FVO")
    private List<BundledGroupProductOffering_FVO> bundledGroupProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdOffr_FVO_category")
    private List<CategoryRef_FVO> category;
}
