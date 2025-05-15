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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductSpecification_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_MVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_MVO> productSpecCharacteristic;
    @ManyToOne
    @JoinColumn(name = "intentSpecification_id")
    @JsonBackReference
    private IntentSpecificationRef_MVO intentSpecification;
    @ManyToOne
    @JoinColumn(name = "targetProductSchema_id")
    @JsonBackReference
    private TargetProductSchema_MVO targetProductSchema;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_MVO_id")
    @JsonManagedReference
    private List<ServiceSpecificationRef_MVO> serviceSpecification;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_MVO_id")
    @JsonManagedReference
    private List<ResourceSpecificationRef_MVO> resourceSpecification;
    private String description;
    private String productNumber;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private String version;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_MVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_MVO> attachment;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_MVO_id")
    @JsonManagedReference
    private List<BundledProductSpecification_MVO> bundledProductSpecification;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_MVO_id")
    @JsonManagedReference
    private List<ProductSpecificationRelationship_MVO> productSpecificationRelationship;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_MVO_id")
    @JsonManagedReference
    private List<CategoryRef_MVO> category;
    private String brand;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_MVO_id")
    @JsonManagedReference
    private List<PolicyRef_MVO> policy;
}
