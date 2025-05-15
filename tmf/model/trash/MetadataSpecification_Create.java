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
public class MetadataSpecification_Create implements java.io.Serializable {
    private Boolean isComposed;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @ManyToOne
    @JoinColumn(name = "targetEntitySchema_id")
    @JsonBackReference
    private TargetEntitySchema targetEntitySchema;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Create_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> metadataSpecCharacteristic;
    private String description;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Create_id")
    @JsonManagedReference
    private List<CompositeMetadataSpecification> compositeMetadataSpecification;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Create_id")
    @JsonManagedReference
    private List<EntitySpecificationRelationship> entitySpecRelationship;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Create_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Create_id")
    @JsonManagedReference
    private List<PolicySpecificationRef> policySpecificationRef;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
