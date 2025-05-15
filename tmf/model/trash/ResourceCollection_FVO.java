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
public class ResourceCollection_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ResourceCollection_FVO_id")
    @JsonManagedReference
    private List<Note> note;
    @JsonProperty("@type")
    private String type;
    private OffsetDateTime endOperatingDate;
    @OneToMany
    @JoinColumn(name = "ResourceCollection_FVO_id")
    @JsonManagedReference
    private List<ResourceRefOrValue_FVO> supportingResource;
    private String description;
    @ManyToOne
    @JoinColumn(name = "usageState_id")
    @JsonBackReference
    private ResourceUsageStateType usageState;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "ResourceCollection_FVO_id")
    @JsonManagedReference
    private List<AttachmentRef> attachment;
    @ManyToOne
    @JoinColumn(name = "administrativeState_id")
    @JsonBackReference
    private ResourceAdministrativeStateType administrativeState;
    @OneToMany
    @JoinColumn(name = "ResourceCollection_FVO_id")
    @JsonManagedReference
    private List<ResourceRefOrValue_FVO> containedResource;
    @OneToMany
    @JoinColumn(name = "ResourceCollection_FVO_id")
    @JsonManagedReference
    private List<ResourceRelationship_FVO> resourceRelationship;
    @OneToMany
    @JoinColumn(name = "ResourceCollection_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    private String href;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "ResourceCollection_FVO_id")
    @JsonManagedReference
    private List<RelatedPlaceRef_FVO> place;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String resourceVersion;
    @OneToMany
    @JoinColumn(name = "ResourceCollection_FVO_id")
    @JsonManagedReference
    private List<Feature_FVO> activationFeature;
    @ManyToOne
    @JoinColumn(name = "resourceSpecification_id")
    @JsonBackReference
    private ResourceSpecificationRef resourceSpecification;
    @OneToMany
    @JoinColumn(name = "ResourceCollection_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> resourceCharacteristic;
    @OneToMany
    @JoinColumn(name = "ResourceCollection_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    @ManyToOne
    @JoinColumn(name = "intent_id")
    @JsonBackReference
    private IntentRef intent;
    @ManyToOne
    @JoinColumn(name = "resourceStatus_id")
    @JsonBackReference
    private ResourceStatusType resourceStatus;
    private String name;
    @OneToMany
    @JoinColumn(name = "ResourceCollection_FVO_id")
    @JsonManagedReference
    private List<RelatedResourceOrderItem> resourceOrderItem;
    @ManyToOne
    @JoinColumn(name = "operationalState_id")
    @JsonBackReference
    private ResourceOperationalStateType operationalState;
    private OffsetDateTime startOperatingDate;
    private String category;
}
