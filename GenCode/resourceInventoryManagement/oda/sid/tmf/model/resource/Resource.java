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
import oda.sid.tmf.model.resource.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Resource extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Resource_id")
    @JsonManagedReference
    private List<Note> note;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private OffsetDateTime endOperatingDate;
    @OneToMany
    @JoinColumn(name = "Resource_id")
    @JsonManagedReference
    private List<ResourceRefOrValue> supportingResource;
    private String resourceVersion;
    @OneToMany
    @JoinColumn(name = "Resource_id")
    @JsonManagedReference
    private List<Feature> activationFeature;
    @ManyToOne
    @JoinColumn(name = "resourceSpecification_id")
    @JsonBackReference
    private ResourceSpecificationRef resourceSpecification;
    private String description;
    @OneToMany
    @JoinColumn(name = "Resource_id")
    @JsonManagedReference
    private List<Characteristic> resourceCharacteristic;
    @OneToMany
    @JoinColumn(name = "Resource_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    @ManyToOne
    @JoinColumn(name = "intent_id")
    @JsonBackReference
    private IntentRef intent;
    @ManyToOne
    @JoinColumn(name = "resourceStatus_id")
    @JsonBackReference
    private ResourceStatusType resourceStatus;
    @ManyToOne
    @JoinColumn(name = "usageState_id")
    @JsonBackReference
    private ResourceUsageStateType usageState;
    @OneToMany
    @JoinColumn(name = "Resource_id")
    @JsonManagedReference
    private List<AttachmentRef> attachment;
    @ManyToOne
    @JoinColumn(name = "administrativeState_id")
    @JsonBackReference
    private ResourceAdministrativeStateType administrativeState;
    private String name;
    @OneToMany
    @JoinColumn(name = "Resource_id")
    @JsonManagedReference
    private List<RelatedResourceOrderItem> resourceOrderItem;
    @OneToMany
    @JoinColumn(name = "Resource_id")
    @JsonManagedReference
    private List<ResourceRelationship> resourceRelationship;
    @OneToMany
    @JoinColumn(name = "Resource_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    @ManyToOne
    @JoinColumn(name = "operationalState_id")
    @JsonBackReference
    private ResourceOperationalStateType operationalState;
    @OneToMany
    @JoinColumn(name = "Resource_id")
    @JsonManagedReference
    private List<RelatedPlaceRef> place;
    private OffsetDateTime startOperatingDate;
    private String category;
}
