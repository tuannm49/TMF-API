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
public class ServiceSpecification_FVO implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "intentSpecification_id")
    @JsonBackReference
    private IntentSpecificationRef_FVO intentSpecification;
    private String lifecycleStatus;
    @OneToMany
    @JoinColumn(name = "ServiceSpecification_FVO_id")
    @JsonManagedReference
    private List<ServiceLevelSpecificationRef_FVO> serviceLevelSpecification;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "targetEntitySchema_id")
    @JsonBackReference
    private TargetEntitySchema_FVO targetEntitySchema;
    @OneToMany
    @JoinColumn(name = "ServiceSpecification_FVO_id")
    @JsonManagedReference
    private List<ResourceSpecificationRef_FVO> resourceSpecification;
    private String description;
    @OneToMany
    @JoinColumn(name = "ServiceSpecification_FVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_FVO> specCharacteristic;
    @OneToMany
    @JoinColumn(name = "ServiceSpecification_FVO_id")
    @JsonManagedReference
    private List<EntitySpecificationRelationship_FVO> entitySpecRelationship;
    @OneToMany
    @JoinColumn(name = "ServiceSpecification_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "ServiceSpecification_FVO_id")
    @JsonManagedReference
    private List<FeatureSpecification_FVO> featureSpecification;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "ServiceSpecification_FVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_FVO> attachment;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "ServiceSpecification_FVO_id")
    @JsonManagedReference
    private List<ConstraintRef_FVO> constraint;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "ServiceSpecification_FVO_id")
    @JsonManagedReference
    private List<EntityRelationship_FVO> serviceSpecRelationship;
}
