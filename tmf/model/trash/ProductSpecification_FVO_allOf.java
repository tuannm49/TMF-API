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
public class ProductSpecification_FVO_allOf implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
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
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<ServiceSpecificationRef_FVO> serviceSpecification;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<ResourceSpecificationRef_FVO> resourceSpecification;
    private String description;
    private String productNumber;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_FVO> attachment;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<BundledProductSpecification_FVO> bundledProductSpecification;
    private OffsetDateTime lastUpdate;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<ProductSpecificationRelationship_FVO> productSpecificationRelationship;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<CategoryRef_FVO> category;
    private String brand;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<PolicyRef_FVO> policy;
}
