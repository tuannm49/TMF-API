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
public class LogicalResourceSpecification_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "intentSpecification_id")
    @JsonBackReference
    private IntentSpecificationRef_MVO intentSpecification;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String description;
    @OneToMany
    @JoinColumn(name = "LogicalResourceSpecification_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "LogicalResourceSpecification_MVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_MVO> resourceSpecCharacteristic;
    @OneToMany
    @JoinColumn(name = "LogicalResourceSpecification_MVO_id")
    @JsonManagedReference
    private List<FeatureSpecification_MVO> featureSpecification;
    @OneToMany
    @JoinColumn(name = "LogicalResourceSpecification_MVO_id")
    @JsonManagedReference
    private List<ResourceSpecificationRelationship_MVO> resourceSpecRelationship;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "LogicalResourceSpecification_MVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_MVO> attachment;
    private OffsetDateTime lastUpdate;
    private String name;
    @ManyToOne
    @JoinColumn(name = "targetResourceSchema_id")
    @JsonBackReference
    private TargetResourceSchema_MVO targetResourceSchema;
    @OneToMany
    @JoinColumn(name = "LogicalResourceSpecification_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String category;
}
