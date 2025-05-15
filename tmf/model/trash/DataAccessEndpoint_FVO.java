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
public class DataAccessEndpoint_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "DataAccessEndpoint_FVO_id")
    @JsonManagedReference
    private List<Note_FVO> note;
    @JsonProperty("@type")
    private String type;
    private OffsetDateTime endOperatingDate;
    @OneToMany
    @JoinColumn(name = "DataAccessEndpoint_FVO_id")
    @JsonManagedReference
    private List<ResourceRefOrValue_FVO> supportingResource;
    private String description;
    @ManyToOne
    @JoinColumn(name = "uriQueryFilter_id")
    @JsonBackReference
    private DataFilterMap_FVO uriQueryFilter;
    @ManyToOne
    @JoinColumn(name = "usageState_id")
    @JsonBackReference
    private ResourceUsageStateType usageState;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "DataAccessEndpoint_FVO_id")
    @JsonManagedReference
    private List<AttachmentRef_FVO> attachment;
    @ManyToOne
    @JoinColumn(name = "administrativeState_id")
    @JsonBackReference
    private ResourceAdministrativeStateType administrativeState;
    @OneToMany
    @JoinColumn(name = "DataAccessEndpoint_FVO_id")
    @JsonManagedReference
    private List<ResourceRelationship_FVO> resourceRelationship;
    @OneToMany
    @JoinColumn(name = "DataAccessEndpoint_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    private String href;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "DataAccessEndpoint_FVO_id")
    @JsonManagedReference
    private List<RelatedPlaceRef_FVO> place;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String value;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String resourceVersion;
    @OneToMany
    @JoinColumn(name = "DataAccessEndpoint_FVO_id")
    @JsonManagedReference
    private List<Feature_FVO> activationFeature;
    @ManyToOne
    @JoinColumn(name = "resourceSpecification_id")
    @JsonBackReference
    private ResourceSpecificationRef_FVO resourceSpecification;
    @OneToMany
    @JoinColumn(name = "DataAccessEndpoint_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> resourceCharacteristic;
    @OneToMany
    @JoinColumn(name = "DataAccessEndpoint_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    @ManyToOne
    @JoinColumn(name = "intent_id")
    @JsonBackReference
    private IntentRef_FVO intent;
    private String uri;
    @ManyToOne
    @JoinColumn(name = "resourceStatus_id")
    @JsonBackReference
    private ResourceStatusType resourceStatus;
    private String name;
    @OneToMany
    @JoinColumn(name = "DataAccessEndpoint_FVO_id")
    @JsonManagedReference
    private List<RelatedResourceOrderItem_FVO> resourceOrderItem;
    @ManyToOne
    @JoinColumn(name = "operationalState_id")
    @JsonBackReference
    private ResourceOperationalStateType operationalState;
    private OffsetDateTime startOperatingDate;
    private String category;
    private String apiType;
}
