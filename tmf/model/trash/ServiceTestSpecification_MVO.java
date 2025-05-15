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
public class ServiceTestSpecification_MVO implements java.io.Serializable {
    private Boolean isBundle;
    private String lifecycleStatus;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "targetEntitySchema_id")
    @JsonBackReference
    private TargetEntitySchema_MVO targetEntitySchema;
    private String description;
    @OneToMany
    @JoinColumn(name = "ServiceTestSpecification_MVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_MVO> specCharacteristic;
    @OneToMany
    @JoinColumn(name = "ServiceTestSpecification_MVO_id")
    @JsonManagedReference
    private List<EntitySpecificationRelationship_MVO> entitySpecRelationship;
    @OneToMany
    @JoinColumn(name = "ServiceTestSpecification_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "ServiceTestSpecification_MVO_id")
    @JsonManagedReference
    private List<ServiceSpecificationRef_MVO> relatedServiceSpecification;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "ServiceTestSpecification_MVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_MVO> attachment;
    @OneToMany
    @JoinColumn(name = "ServiceTestSpecification_MVO_id")
    @JsonManagedReference
    private List<TestMeasureDefinition_MVO> testMeasureDefinition;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "ServiceTestSpecification_MVO_id")
    @JsonManagedReference
    private List<ServiceTestSpecRelationship_MVO> serviceTestSpecRelationship;
    @OneToMany
    @JoinColumn(name = "ServiceTestSpecification_MVO_id")
    @JsonManagedReference
    private List<ConstraintRef_MVO> constraint;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
