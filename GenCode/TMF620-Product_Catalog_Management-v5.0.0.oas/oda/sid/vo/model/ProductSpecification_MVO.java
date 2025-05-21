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
public class ProductSpecification_MVO extends Entity_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductSpecification_MVO_id")
    private List<CharacteristicSpecification_MVO> productSpecCharacteristic;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="id", column=@Column(name = "intentSpecification_id")),
            @AttributeOverride(name="name", column=@Column(name = "intentSpecification_name")),
            @AttributeOverride(name="version", column=@Column(name = "intentSpecification_version")),
            @AttributeOverride(name="href", column=@Column(name = "intentSpecification_href")),
            @AttributeOverride(name="type", column=@Column(name = "intentSpecification_type")),
            @AttributeOverride(name="baseType", column=@Column(name = "intentSpecification_baseType")),
            @AttributeOverride(name="referredType", column=@Column(name = "intentSpecification_referredType")),
            @AttributeOverride(name="schemaLocation", column=@Column(name = "intentSpecification_schemaLocation"))
    })
    private IntentSpecificationRef_MVO intentSpecification;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "targetProductSchema_id")
    private TargetProductSchema_MVO targetProductSchema;
    private String lifecycleStatus;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="type", column=@Column(name = "target_type")),@AttributeOverride(name="schemaLocation", column=@Column(name = "target_schemaLocation"))})
    private TimePeriod validFor;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_serviceSpecification", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<ServiceSpecificationRef_MVO> serviceSpecification;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_resourceSpecification", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<ResourceSpecificationRef_MVO> resourceSpecification;
    private String productNumber;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_relatedParty", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_attachment", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<AttachmentRefOrValue_MVO> attachment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductSpecification_MVO_id")
    private List<BundledProductSpecification_MVO> bundledProductSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductSpecification_MVO_id")
    private List<ProductSpecificationRelationship_MVO> productSpecificationRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductSpecification_MVO_id")
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_category", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<CategoryRef_MVO> category;
    private String brand;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_policy", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<PolicyRef_MVO> policy;
}
