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
public class ProductOffering_MVO extends Entity_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "productSpecification_id")
    private ProductSpecificationRef_MVO productSpecification;
    private String lifecycleStatus;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "serviceCandidate_id")
    private ServiceCandidateRef_MVO serviceCandidate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_MVO_id")
    private List<ChannelRef_MVO> channel;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_MVO_id")
    private List<CharacteristicSpecification_MVO> productOfferingCharacteristic;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_MVO_id")
    private List<ProductOfferingPriceRefOrValue_MVO> productOfferingPrice;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "resourceCandidate_id")
    private ResourceCandidateRef_MVO resourceCandidate;
    private String statusReason;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_MVO_id")
    private List<BundledProductOffering_MVO> bundledProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_MVO_id")
    private List<AttachmentRefOrValue_MVO> attachment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_MVO_id")
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_MVO_id")
    private List<PlaceRef_MVO> place;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_MVO_id")
    private List<ProductOfferingTerm_MVO> productOfferingTerm;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_MVO_id")
    private List<MarketSegmentRef_MVO> marketSegment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_MVO_id")
    private List<PolicyRef_MVO> policy;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_MVO_id")
    private List<ProductSpecificationCharacteristicValueUse_MVO> prodSpecCharValueUse;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_MVO_id")
    private List<AgreementRef_MVO> agreement;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="type", column=@Column(name = "target_type")),@AttributeOverride(name="schemaLocation", column=@Column(name = "target_schemaLocation"))})
    private TimePeriod validFor;
    private Boolean isSellable;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_MVO_id")
    private List<AllowedProductAction_MVO> allowedAction;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "serviceLevelAgreement_id")
    private SLARef_MVO serviceLevelAgreement;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_MVO_id")
    private List<ProductOfferingRelationship_MVO> productOfferingRelationship;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_MVO_id")
    private List<BundledGroupProductOffering_MVO> bundledGroupProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_MVO_id")
    private List<CategoryRef_MVO> category;
}
