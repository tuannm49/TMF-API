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
public class ProductSpecification_FVO_allOf implements java.io.Serializable {
    private String brand;
    private String description;
    private Boolean isBundle;
    private String productNumber;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<CategoryRef_FVO> category;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String version;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_FVO> productSpecCharacteristic;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<ServiceSpecificationRef_FVO> serviceSpecification;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<BundledProductSpecification_FVO> bundledProductSpecification;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<ProductSpecificationRelationship_FVO> productSpecificationRelationship;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<ResourceSpecificationRef_FVO> resourceSpecification;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_FVO> attachment;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<PolicyRef_FVO> policy;
    @ManyToOne
    @JoinColumn(name = "targetProductSchema_id")
    @JsonBackReference
    private TargetProductSchema_FVO targetProductSchema;
    @ManyToOne
    @JoinColumn(name = "intentSpecification_id")
    @JsonBackReference
    private IntentSpecificationRef_FVO intentSpecification;
    private OffsetDateTime lastUpdate;
    private String lifecycleStatus;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
}
