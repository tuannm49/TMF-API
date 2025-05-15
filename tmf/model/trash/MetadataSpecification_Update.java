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
public class MetadataSpecification_Update implements java.io.Serializable {
    private Boolean isComposed;
    private String lifecycleStatus;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Update_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @ManyToOne
    @JoinColumn(name = "targetEntitySchema_id")
    @JsonBackReference
    private TargetEntitySchema targetEntitySchema;
    private String name;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Update_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> metadataSpecCharacteristic;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Update_id")
    @JsonManagedReference
    private List<PolicySpecificationRef> policySpecificationRef;
    private String description;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Update_id")
    @JsonManagedReference
    private List<CompositeMetadataSpecification> compositeMetadataSpecification;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Update_id")
    @JsonManagedReference
    private List<EntitySpecificationRelationship> entitySpecRelationship;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Update_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
}
