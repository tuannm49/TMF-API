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
public class ProductSpecification_FVO implements java.io.Serializable {
    private Boolean isBundle;
    private String lifecycleStatus;
    @JsonProperty("@type")
    private String type;
    private String description;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_FVO> attachment;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_id")
    @JsonManagedReference
    private List<BundledProductSpecification_FVO> bundledProductSpecification;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_id")
    @JsonManagedReference
    private List<ProductSpecificationRelationship_FVO> productSpecificationRelationship;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String brand;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_id")
    @JsonManagedReference
    private List<PolicyRef_FVO> policy;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_FVO> productSpecCharacteristic;
    @ManyToOne
    @JoinColumn(name = "intentSpecification_id")
    @JsonBackReference
    private IntentSpecificationRef_FVO intentSpecification;
    @ManyToOne
    @JoinColumn(name = "targetProductSchema_id")
    @JsonBackReference
    private TargetProductSchema_FVO targetProductSchema;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_id")
    @JsonManagedReference
    private List<ServiceSpecificationRef_FVO> serviceSpecification;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_id")
    @JsonManagedReference
    private List<ResourceSpecificationRef_FVO> resourceSpecification;
    private String productNumber;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    private String version;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_id")
    @JsonManagedReference
    private List<CategoryRef_FVO> category;
}
