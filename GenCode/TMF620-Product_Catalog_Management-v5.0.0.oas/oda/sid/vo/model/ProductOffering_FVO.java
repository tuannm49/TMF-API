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
public class ProductOffering_FVO extends Entity_FVO implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "productSpecification_id")
    private ProductSpecificationRef_FVO productSpecification;
    private String lifecycleStatus;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "serviceCandidate_id")
    private ServiceCandidateRef_FVO serviceCandidate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<ChannelRef_FVO> channel;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<CharacteristicSpecification_FVO> productOfferingCharacteristic;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<ProductOfferingPriceRefOrValue_FVO> productOfferingPrice;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "resourceCandidate_id")
    private ResourceCandidateRef_FVO resourceCandidate;
    private String statusReason;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<BundledProductOffering_FVO> bundledProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<AttachmentRefOrValue_FVO> attachment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<PlaceRef_FVO> place;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<ProductOfferingTerm_FVO> productOfferingTerm;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<MarketSegmentRef_FVO> marketSegment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<PolicyRef_FVO> policy;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<ProductSpecificationCharacteristicValueUse_FVO> prodSpecCharValueUse;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<AgreementRef_FVO> agreement;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="type", column=@Column(name = "target_type")),@AttributeOverride(name="schemaLocation", column=@Column(name = "target_schemaLocation"))})
    private TimePeriod validFor;
    private Boolean isSellable;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<AllowedProductAction_FVO> allowedAction;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "serviceLevelAgreement_id")
    private SLARef_FVO serviceLevelAgreement;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<ProductOfferingRelationship_FVO> productOfferingRelationship;
    private Date lastUpdate;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<BundledGroupProductOffering_FVO> bundledGroupProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<CategoryRef_FVO> category;
}
