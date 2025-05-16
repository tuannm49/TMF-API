package oda.sid.tmf.model.product;

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
public class ProductOffering_allOf implements java.io.Serializable {
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
    @JoinColumn(name = "ProductOffering_allOf_id")
    @JsonManagedReference
    private List<PlaceRef> place;
    @ManyToOne
    @JoinColumn(name = "serviceLevelAgreement_id")
    @JsonBackReference
    private SLARef serviceLevelAgreement;
    @OneToMany
    @JoinColumn(name = "ProductOffering_allOf_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    @ManyToOne
    @JoinColumn(name = "serviceCandidate_id")
    @JsonBackReference
    private ServiceCandidateRef serviceCandidate;
    @OneToMany
    @JoinColumn(name = "ProductOffering_allOf_id")
    @JsonManagedReference
    private List<CategoryRef> category;
    @ManyToOne
    @JoinColumn(name = "resourceCandidate_id")
    @JsonBackReference
    private ResourceCandidateRef resourceCandidate;
    @OneToMany
    @JoinColumn(name = "ProductOffering_allOf_id")
    @JsonManagedReference
    private List<ProductOfferingTerm> productOfferingTerm;
    @OneToMany
    @JoinColumn(name = "ProductOffering_allOf_id")
    @JsonManagedReference
    private List<ProductOfferingPriceRefOrValue> productOfferingPrice;
    @OneToMany
    @JoinColumn(name = "ProductOffering_allOf_id")
    @JsonManagedReference
    private List<AgreementRef> agreement;
    @OneToMany
    @JoinColumn(name = "ProductOffering_allOf_id")
    @JsonManagedReference
    private List<BundledProductOffering> bundledProductOffering;
    @OneToMany
    @JoinColumn(name = "ProductOffering_allOf_id")
    @JsonManagedReference
    private List<BundledGroupProductOffering> bundledGroupProductOffering;
    @OneToMany
    @JoinColumn(name = "ProductOffering_allOf_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @OneToMany
    @JoinColumn(name = "ProductOffering_allOf_id")
    @JsonManagedReference
    private List<MarketSegmentRef> marketSegment;
    @OneToMany
    @JoinColumn(name = "ProductOffering_allOf_id")
    @JsonManagedReference
    private List<ProductOfferingRelationship> productOfferingRelationship;
    @OneToMany
    @JoinColumn(name = "ProductOffering_allOf_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> productOfferingCharacteristic;
    @OneToMany
    @JoinColumn(name = "ProductOffering_allOf_id")
    @JsonManagedReference
    private List<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse;
    @OneToMany
    @JoinColumn(name = "ProductOffering_allOf_id")
    @JsonManagedReference
    private List<PolicyRef> policy;
    @OneToMany
    @JoinColumn(name = "ProductOffering_allOf_id")
    @JsonManagedReference
    private List<AllowedProductAction> allowedAction;
    private OffsetDateTime lastUpdate;
    private String lifecycleStatus;
    private String name;
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef productSpecification;
    @OneToMany
    @JoinColumn(name = "ProductOffering_allOf_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
}
