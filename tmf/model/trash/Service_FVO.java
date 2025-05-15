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
public class Service_FVO implements java.io.Serializable {
    private String serviceType;
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<Note> note;
    private String serviceDate;
    private OffsetDateTime endDate;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<ResourceRef> supportingResource;
    private Boolean hasStarted;
    private String description;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<RelatedServiceOrderItem> serviceOrderItem;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<ServiceRelationship_FVO> serviceRelationship;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<Feature_FVO> feature;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    private String href;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue_FVO> place;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ServiceStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "operatingStatus_id")
    @JsonBackReference
    private ServiceOperatingStatusType operatingStatus;
    private Boolean isStateful;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> serviceCharacteristic;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<RelatedEntityRefOrValue_FVO> relatedEntity;
    @ManyToOne
    @JoinColumn(name = "serviceSpecification_id")
    @JsonBackReference
    private ServiceSpecificationRef serviceSpecification;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<ServiceRefOrValue> supportingService;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    @ManyToOne
    @JoinColumn(name = "intent_id")
    @JsonBackReference
    private IntentRefOrValue_FVO intent;
    private Boolean isServiceEnabled;
    private String startMode;
    private String name;
    private String category;
    private OffsetDateTime startDate;
}
