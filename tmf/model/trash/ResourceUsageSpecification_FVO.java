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
public class ResourceUsageSpecification_FVO implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "ResourceUsageSpecification_FVO_id")
    @JsonManagedReference
    private List<ResourceUsageSpecificationRef_FVO> bundledResourceUsageSpecification;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ResourceUsageSpecification_FVO_id")
    @JsonManagedReference
    private List<ResourceSpecificationRef_FVO> resourceSpecification;
    @OneToMany
    @JoinColumn(name = "ResourceUsageSpecification_FVO_id")
    @JsonManagedReference
    private List<ResourceUsageSpecRelationship_FVO> resourceUsageSpecRelationship;
    private String description;
    @OneToMany
    @JoinColumn(name = "ResourceUsageSpecification_FVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_FVO> specCharacteristic;
    private String version;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "ResourceUsageSpecification_FVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_FVO> attachment;
    private OffsetDateTime lastUpdate;
    private String name;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
