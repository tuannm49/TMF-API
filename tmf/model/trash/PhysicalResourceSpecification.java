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
public class PhysicalResourceSpecification implements java.io.Serializable {
    private Boolean isBundle;
    private String lifecycleStatus;
    @JsonProperty("@type")
    private String type;
    private String part;
    private String description;
    @OneToMany
    @JoinColumn(name = "PhysicalResourceSpecification_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> resourceSpecCharacteristic;
    @OneToMany
    @JoinColumn(name = "PhysicalResourceSpecification_id")
    @JsonManagedReference
    private List<ResourceSpecificationRelationship> resourceSpecRelationship;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "PhysicalResourceSpecification_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    private String vendor;
    @ManyToOne
    @JoinColumn(name = "targetResourceSchema_id")
    @JsonBackReference
    private TargetResourceSchema targetResourceSchema;
    @OneToMany
    @JoinColumn(name = "PhysicalResourceSpecification_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    private String model;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String sku;
    @ManyToOne
    @JoinColumn(name = "intentSpecification_id")
    @JsonBackReference
    private IntentSpecificationRef intentSpecification;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "PhysicalResourceSpecification_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "PhysicalResourceSpecification_id")
    @JsonManagedReference
    private List<FeatureSpecification> featureSpecification;
    private OffsetDateTime lastUpdate;
    private String name;
    private String category;
}
