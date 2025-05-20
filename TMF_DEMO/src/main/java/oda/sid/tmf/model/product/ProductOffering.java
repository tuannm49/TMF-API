package oda.sid.tmf.model.product;

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
public class ProductOffering extends BaseEntity implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "productSpecification_id")
    private ProductSpecificationRef productSpecification;
    private String lifecycleStatus;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "serviceCandidate_id")
    private ServiceCandidateRef serviceCandidate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_id")
    private List<ChannelRef> channel;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_id")
    private List<CharacteristicSpecification> productOfferingCharacteristic;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_id")
    private List<ProductOfferingPriceRefOrValue> productOfferingPrice;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "resourceCandidate_id")
    private ResourceCandidateRef resourceCandidate;
    private String statusReason;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_id")
    private List<BundledProductOffering> bundledProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_id")
    private List<AttachmentRefOrValue> attachment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_id")
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_id")
    private List<PlaceRef> place;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_id")
    private List<ProductOfferingTerm> productOfferingTerm;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_id")
    private List<MarketSegmentRef> marketSegment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_id")
    private List<PolicyRef> policy;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_id")
    private List<ProductSpecificationCharacteristicValueUse> prodSpecCharValueUse;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_id")
    private List<AgreementRef> agreement;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="type", column=@Column(name = "target_type")),@AttributeOverride(name="schemaLocation", column=@Column(name = "target_schemaLocation"))})
    private TimePeriod validFor;
    private Boolean isSellable;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_id")
    private List<AllowedProductAction> allowedAction;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "serviceLevelAgreement_id")
    private SLARef serviceLevelAgreement;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_id")
    private List<ProductOfferingRelationship> productOfferingRelationship;
    private Date lastUpdate;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_id")
    private List<BundledGroupProductOffering> bundledGroupProductOffering;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_id")
    private List<CategoryRef> category;
}
