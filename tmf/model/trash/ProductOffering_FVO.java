package com.example.trash;

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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOffering_FVO implements java.io.Serializable {
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
    @JsonProperty("@type")
    private String type;
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
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_FVO> attachment;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "ProductOffering_FVO_id")
    @JsonManagedReference
    private List<PlaceRef_FVO> place;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
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
