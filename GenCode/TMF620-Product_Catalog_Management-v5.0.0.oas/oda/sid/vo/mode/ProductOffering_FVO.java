package oda.sid.vo.mode;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.vo.mode.Entity_FVO;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOffering_FVO extends Entity_FVO implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef_FVO productSpecification;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "serviceCandidate_id")
    @JsonBackReference
    private ServiceCandidateRef_FVO serviceCandidate;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<ChannelRef_FVO> channel;
    private String description;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_FVO> productOfferingCharacteristic;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<ProductOfferingPriceRefOrValue_FVO> productOfferingPrice;
    @ManyToOne
    @JoinColumn(name = "resourceCandidate_id")
    @JsonBackReference
    private ResourceCandidateRef_FVO resourceCandidate;
    private String statusReason;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<BundledProductOffering_FVO> bundledProductOffering;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_FVO> attachment;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<PlaceRef_FVO> place;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<ProductOfferingTerm_FVO> productOfferingTerm;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<MarketSegmentRef_FVO> marketSegment;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<PolicyRef_FVO> policy;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<ProductSpecificationCharacteristicValueUse_FVO> prodSpecCharValueUse;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<AgreementRef_FVO> agreement;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private Boolean isSellable;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<AllowedProductAction_FVO> allowedAction;
    @ManyToOne
    @JoinColumn(name = "serviceLevelAgreement_id")
    @JsonBackReference
    private SLARef_FVO serviceLevelAgreement;
    private String version;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<ProductOfferingRelationship_FVO> productOfferingRelationship;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<BundledGroupProductOffering_FVO> bundledGroupProductOffering;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<CategoryRef_FVO> category;
}
