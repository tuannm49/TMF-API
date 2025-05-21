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
import oda.sid.tmf.model.base.*;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOffering_FVO extends Entity_FVO implements java.io.Serializable {
    private Boolean isBundle;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="id", column=@Column(name = "productSpecification_id")),
            @AttributeOverride(name="name", column=@Column(name = "productSpecification_name")),
            @AttributeOverride(name="version", column=@Column(name = "productSpecification_version")),
            @AttributeOverride(name="href", column=@Column(name = "productSpecification_href")),
            @AttributeOverride(name="type", column=@Column(name = "productSpecification_type")),
            @AttributeOverride(name="baseType", column=@Column(name = "productSpecification_baseType")),
            @AttributeOverride(name="referredType", column=@Column(name = "productSpecification_referredType")),
            @AttributeOverride(name="schemaLocation", column=@Column(name = "productSpecification_schemaLocation"))
    })
    private ProductSpecificationRef_FVO productSpecification;
    private String lifecycleStatus;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="id", column=@Column(name = "serviceCandidate_id")),
            @AttributeOverride(name="name", column=@Column(name = "serviceCandidate_name")),
            @AttributeOverride(name="version", column=@Column(name = "serviceCandidate_version")),
            @AttributeOverride(name="href", column=@Column(name = "serviceCandidate_href")),
            @AttributeOverride(name="type", column=@Column(name = "serviceCandidate_type")),
            @AttributeOverride(name="baseType", column=@Column(name = "serviceCandidate_baseType")),
            @AttributeOverride(name="referredType", column=@Column(name = "serviceCandidate_referredType")),
            @AttributeOverride(name="schemaLocation", column=@Column(name = "serviceCandidate_schemaLocation"))
    })
    private ServiceCandidateRef_FVO serviceCandidate;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_channel", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<ChannelRef_FVO> channel;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<CharacteristicSpecification_FVO> productOfferingCharacteristic;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_productOfferingPrice", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<ProductOfferingPriceRefOrValue_FVO> productOfferingPrice;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="id", column=@Column(name = "resourceCandidate_id")),
            @AttributeOverride(name="name", column=@Column(name = "resourceCandidate_name")),
            @AttributeOverride(name="version", column=@Column(name = "resourceCandidate_version")),
            @AttributeOverride(name="href", column=@Column(name = "resourceCandidate_href")),
            @AttributeOverride(name="type", column=@Column(name = "resourceCandidate_type")),
            @AttributeOverride(name="baseType", column=@Column(name = "resourceCandidate_baseType")),
            @AttributeOverride(name="referredType", column=@Column(name = "resourceCandidate_referredType")),
            @AttributeOverride(name="schemaLocation", column=@Column(name = "resourceCandidate_schemaLocation"))
    })
    private ResourceCandidateRef_FVO resourceCandidate;
    private String statusReason;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<BundledProductOffering_FVO> bundledProductOffering;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_attachment", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<AttachmentRefOrValue_FVO> attachment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_place", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<PlaceRef_FVO> place;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<ProductOfferingTerm_FVO> productOfferingTerm;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_marketSegment", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<MarketSegmentRef_FVO> marketSegment;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_policy", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<PolicyRef_FVO> policy;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<ProductSpecificationCharacteristicValueUse_FVO> prodSpecCharValueUse;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_agreement", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<AgreementRef_FVO> agreement;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="type", column=@Column(name = "target_type")),@AttributeOverride(name="schemaLocation", column=@Column(name = "target_schemaLocation"))})
    private TimePeriod validFor;
    private Boolean isSellable;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<AllowedProductAction_FVO> allowedAction;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="id", column=@Column(name = "serviceLevelAgreement_id")),
            @AttributeOverride(name="name", column=@Column(name = "serviceLevelAgreement_name")),
            @AttributeOverride(name="version", column=@Column(name = "serviceLevelAgreement_version")),
            @AttributeOverride(name="href", column=@Column(name = "serviceLevelAgreement_href")),
            @AttributeOverride(name="type", column=@Column(name = "serviceLevelAgreement_type")),
            @AttributeOverride(name="baseType", column=@Column(name = "serviceLevelAgreement_baseType")),
            @AttributeOverride(name="referredType", column=@Column(name = "serviceLevelAgreement_referredType")),
            @AttributeOverride(name="schemaLocation", column=@Column(name = "serviceLevelAgreement_schemaLocation"))
    })
    private SLARef_FVO serviceLevelAgreement;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<ProductOfferingRelationship_FVO> productOfferingRelationship;
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductOffering_FVO_id")
    private List<BundledGroupProductOffering_FVO> bundledGroupProductOffering;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_category", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<CategoryRef_FVO> category;
}
