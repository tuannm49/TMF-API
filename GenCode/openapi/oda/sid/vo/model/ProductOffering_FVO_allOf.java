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
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOffering_FVO_allOf implements java.io.Serializable {
    private String description;
    private Boolean isBundle;
    private Boolean isSellable;
    private String statusReason;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String version;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<PlaceRef_FVO> place;
    @ManyToOne
    @JoinColumn(name = "serviceLevelAgreement_id")
    @JsonBackReference
    private SLARef_FVO serviceLevelAgreement;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<ChannelRef_FVO> channel;
    @ManyToOne
    @JoinColumn(name = "serviceCandidate_id")
    @JsonBackReference
    private ServiceCandidateRef_FVO serviceCandidate;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<CategoryRef_FVO> category;
    @ManyToOne
    @JoinColumn(name = "resourceCandidate_id")
    @JsonBackReference
    private ResourceCandidateRef_FVO resourceCandidate;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<ProductOfferingTerm_FVO> productOfferingTerm;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<ProductOfferingPriceRefOrValue_FVO> productOfferingPrice;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<AgreementRef_FVO> agreement;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<BundledProductOffering_FVO> bundledProductOffering;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<BundledGroupProductOffering_FVO> bundledGroupProductOffering;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_FVO> attachment;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<MarketSegmentRef_FVO> marketSegment;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<ProductOfferingRelationship_FVO> productOfferingRelationship;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_FVO> productOfferingCharacteristic;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<ProductSpecificationCharacteristicValueUse_FVO> prodSpecCharValueUse;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<PolicyRef_FVO> policy;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<AllowedProductAction_FVO> allowedAction;
    private OffsetDateTime lastUpdate;
    private String lifecycleStatus;
    private String name;
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef_FVO productSpecification;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
}
