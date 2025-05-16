package oda.sid.vo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOffering_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef_MVO productSpecification;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "serviceCandidate_id")
    @JsonBackReference
    private ServiceCandidateRef_MVO serviceCandidate;
    @OneToMany
    @JoinColumn(name = "ProductOffering_MVO_id")
    @JsonManagedReference
    private List<ChannelRef_MVO> channel;
    private String description;
    @OneToMany
    @JoinColumn(name = "ProductOffering_MVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_MVO> productOfferingCharacteristic;
    @OneToMany
    @JoinColumn(name = "ProductOffering_MVO_id")
    @JsonManagedReference
    private List<ProductOfferingPriceRefOrValue_MVO> productOfferingPrice;
    @ManyToOne
    @JoinColumn(name = "resourceCandidate_id")
    @JsonBackReference
    private ResourceCandidateRef_MVO resourceCandidate;
    private String statusReason;
    @OneToMany
    @JoinColumn(name = "ProductOffering_MVO_id")
    @JsonManagedReference
    private List<BundledProductOffering_MVO> bundledProductOffering;
    @OneToMany
    @JoinColumn(name = "ProductOffering_MVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_MVO> attachment;
    @OneToMany
    @JoinColumn(name = "ProductOffering_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ProductOffering_MVO_id")
    @JsonManagedReference
    private List<PlaceRef_MVO> place;
    @OneToMany
    @JoinColumn(name = "ProductOffering_MVO_id")
    @JsonManagedReference
    private List<ProductOfferingTerm_MVO> productOfferingTerm;
    @OneToMany
    @JoinColumn(name = "ProductOffering_MVO_id")
    @JsonManagedReference
    private List<MarketSegmentRef_MVO> marketSegment;
    @OneToMany
    @JoinColumn(name = "ProductOffering_MVO_id")
    @JsonManagedReference
    private List<PolicyRef_MVO> policy;
    @OneToMany
    @JoinColumn(name = "ProductOffering_MVO_id")
    @JsonManagedReference
    private List<ProductSpecificationCharacteristicValueUse_MVO> prodSpecCharValueUse;
    @OneToMany
    @JoinColumn(name = "ProductOffering_MVO_id")
    @JsonManagedReference
    private List<AgreementRef_MVO> agreement;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private Boolean isSellable;
    @OneToMany
    @JoinColumn(name = "ProductOffering_MVO_id")
    @JsonManagedReference
    private List<AllowedProductAction_MVO> allowedAction;
    @ManyToOne
    @JoinColumn(name = "serviceLevelAgreement_id")
    @JsonBackReference
    private SLARef_MVO serviceLevelAgreement;
    private String version;
    @OneToMany
    @JoinColumn(name = "ProductOffering_MVO_id")
    @JsonManagedReference
    private List<ProductOfferingRelationship_MVO> productOfferingRelationship;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductOffering_MVO_id")
    @JsonManagedReference
    private List<BundledGroupProductOffering_MVO> bundledGroupProductOffering;
    @OneToMany
    @JoinColumn(name = "ProductOffering_MVO_id")
    @JsonManagedReference
    private List<CategoryRef_MVO> category;
}
