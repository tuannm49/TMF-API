package oda.sid.tmf.model.resource;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceRefOrValue implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private String category;
    private String description;
    private OffsetDateTime endOperatingDate;
    private String name;
    private String resourceVersion;
    private OffsetDateTime startOperatingDate;
    @OneToMany
    @JoinColumn(name = "ResourceRefOrValue_id")
    @JsonManagedReference
    private List<Feature> activationFeature;
    @ManyToOne
    @JoinColumn(name = "administrativeState_id")
    @JsonBackReference
    private ResourceAdministrativeStateType administrativeState;
    @OneToMany
    @JoinColumn(name = "ResourceRefOrValue_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @OneToMany
    @JoinColumn(name = "ResourceRefOrValue_id")
    @JsonManagedReference
    private List<Note> note;
    @ManyToOne
    @JoinColumn(name = "operationalState_id")
    @JsonBackReference
    private ResourceOperationalStateType operationalState;
    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue place;
    @OneToMany
    @JoinColumn(name = "ResourceRefOrValue_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @OneToMany
    @JoinColumn(name = "ResourceRefOrValue_id")
    @JsonManagedReference
    private List<Characteristic> resourceCharacteristic;
    @OneToMany
    @JoinColumn(name = "ResourceRefOrValue_id")
    @JsonManagedReference
    private List<ResourceRelationship> resourceRelationship;
    @ManyToOne
    @JoinColumn(name = "resourceSpecification_id")
    @JsonBackReference
    private ResourceSpecificationRef resourceSpecification;
    @ManyToOne
    @JoinColumn(name = "resourceStatus_id")
    @JsonBackReference
    private ResourceStatusType resourceStatus;
    @ManyToOne
    @JoinColumn(name = "usageState_id")
    @JsonBackReference
    private ResourceUsageStateType usageState;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
    @JsonProperty("@referredType")
    private String referredType;
}
