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
public class ProductOffering implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef productSpecification;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "serviceCandidate_id")
    @JsonBackReference
    private ServiceCandidateRef serviceCandidate;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ProductOffering_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    private String description;
    @OneToMany
    @JoinColumn(name = "ProductOffering_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> productOfferingCharacteristic;
    @OneToMany
    @JoinColumn(name = "ProductOffering_id")
    @JsonManagedReference
    private List<ProductOfferingPriceRefOrValue> productOfferingPrice;
    @ManyToOne
    @JoinColumn(name = "resourceCandidate_id")
    @JsonBackReference
    private ResourceCandidateRef resourceCandidate;
    private String statusReason;
    @OneToMany
    @JoinColumn(name = "ProductOffering_id")
    @JsonManagedReference
    private List<BundledProductOffering> bundledProductOffering;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "ProductOffering_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @OneToMany
    @JoinColumn(name = "ProductOffering_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    private String href;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "ProductOffering_id")
    @JsonManagedReference
    private List<PlaceRef> place;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "ProductOffering_id")
    @JsonManagedReference
    private List<ProductOfferingTerm> productOfferingTerm;
    @OneToMany
    @JoinColumn(name = "ProductOffering_id")
    @JsonManagedReference
    private List<MarketSegmentRef> marketSegment;
    @OneToMany
    @JoinColumn(name = "ProductOffering_id")
    @JsonManagedReference
    private List<PolicyRef> policy;
    @OneToMany
    @JoinColumn(name = "ProductOffering_id")
    @JsonManagedReference
    private List<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse;
    @OneToMany
    @JoinColumn(name = "ProductOffering_id")
    @JsonManagedReference
    private List<AgreementRef> agreement;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private Boolean isSellable;
    @OneToMany
    @JoinColumn(name = "ProductOffering_id")
    @JsonManagedReference
    private List<AllowedProductAction> allowedAction;
    @ManyToOne
    @JoinColumn(name = "serviceLevelAgreement_id")
    @JsonBackReference
    private SLARef serviceLevelAgreement;
    private String version;
    @OneToMany
    @JoinColumn(name = "ProductOffering_id")
    @JsonManagedReference
    private List<ProductOfferingRelationship> productOfferingRelationship;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductOffering_id")
    @JsonManagedReference
    private List<BundledGroupProductOffering> bundledGroupProductOffering;
    @OneToMany
    @JoinColumn(name = "ProductOffering_id")
    @JsonManagedReference
    private List<CategoryRef> category;
}
