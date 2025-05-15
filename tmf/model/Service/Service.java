package com.example.Service;

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
public class Service implements java.io.Serializable {
    private Boolean isBundle;
    private String serviceType;
    @OneToMany
    @JoinColumn(name = "Service_id")
    @JsonManagedReference
    private List<Note> note;
    private String serviceDate;
    private OffsetDateTime endDate;
    @OneToMany
    @JoinColumn(name = "Service_id")
    @JsonManagedReference
    private List<ResourceRef> supportingResource;
    @JsonProperty("@type")
    private String type;
    private Boolean hasStarted;
    private String description;
    @OneToMany
    @JoinColumn(name = "Service_id")
    @JsonManagedReference
    private List<RelatedServiceOrderItem> serviceOrderItem;
    @OneToMany
    @JoinColumn(name = "Service_id")
    @JsonManagedReference
    private List<ServiceRelationship> serviceRelationship;
    @OneToMany
    @JoinColumn(name = "Service_id")
    @JsonManagedReference
    private List<Feature> feature;
    @JsonProperty("@baseType")
    private String baseType;
    @Id
    private String id;
    private String href;
    @OneToMany
    @JoinColumn(name = "Service_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue> place;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ServiceStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private Boolean isStateful;
    @OneToMany
    @JoinColumn(name = "Service_id")
    @JsonManagedReference
    private List<Characteristic> serviceCharacteristic;
    @OneToMany
    @JoinColumn(name = "Service_id")
    @JsonManagedReference
    private List<RelatedEntityRefOrValue> relatedEntity;
    @ManyToOne
    @JoinColumn(name = "serviceSpecification_id")
    @JsonBackReference
    private ServiceSpecificationRef serviceSpecification;
    @OneToMany
    @JoinColumn(name = "Service_id")
    @JsonManagedReference
    private List<ServiceRefOrValue> supportingService;
    @OneToMany
    @JoinColumn(name = "Service_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private Boolean isServiceEnabled;
    private String startMode;
    private String name;
    private String category;
    private OffsetDateTime startDate;
}
