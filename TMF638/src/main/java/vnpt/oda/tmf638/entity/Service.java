package vnpt.oda.tmf638.entity;


import jakarta.persistence.*;
import lombok.Data;
import vnpt.oda.tmf638.dto.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "href")
    private String href;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "has_started")
    private Boolean hasStarted;

    @Column(name = "is_bundle")
    private Boolean isBundle;

    @Column(name = "is_service_enabled")
    private Boolean isServiceEnabled;

    @Column(name = "is_stateful")
    private Boolean isStateful;

    @Column(name = "name")
    private String name;

    @Column(name = "operating_status")
    private String operatingStatus;

    @Column(name = "service_date")
    private LocalDateTime serviceDate;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "start_mode")
    private String startMode;

    @Column(name = "state")
    private String state;

    @Column(name = "base_type")
    private String baseType;

    @Column(name = "schema_location")
    private String schemaLocation;

    @Column(name = "type")
    private String type;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "attachments")
    private List<Attachment> attachments;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "serviceCharacteristics")
    private List<ServiceCharacteristic> serviceCharacteristics;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "externalIdentifiers")
    private List<ExternalIdentifier> externalIdentifiers;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "features")
    private List<Feature> features;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "relatedPlaces")
    private List<RelatedPlace> relatedPlaces;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "relatedParties")
    private List<RelatedParty> relatedParties;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "serviceRelationships")
    private List<ServiceRelationship> serviceRelationships;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "supportingServices")
    private List<SupportingService> supportingServices;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "supportingResources")
    private List<SupportingResource> supportingResources;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "notes")
    private List<Note> notes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "serviceOrderItems")
    private List<ServiceOrderItem> serviceOrderItems;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "intents")
    private List<Intent> intents;*/
}

