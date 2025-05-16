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
public class ResourceSpecification extends Entity implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "intentSpecification_id")
    @JsonBackReference
    private IntentSpecificationRef intentSpecification;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String description;
    @OneToMany
    @JoinColumn(name = "ResourceSpecification_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "ResourceSpecification_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> resourceSpecCharacteristic;
    @OneToMany
    @JoinColumn(name = "ResourceSpecification_id")
    @JsonManagedReference
    private List<FeatureSpecification> featureSpecification;
    @OneToMany
    @JoinColumn(name = "ResourceSpecification_id")
    @JsonManagedReference
    private List<ResourceSpecificationRelationship> resourceSpecRelationship;
    @OneToMany
    @JoinColumn(name = "ResourceSpecification_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    private OffsetDateTime lastUpdate;
    private String name;
    @ManyToOne
    @JoinColumn(name = "targetResourceSchema_id")
    @JsonBackReference
    private TargetResourceSchema targetResourceSchema;
    @OneToMany
    @JoinColumn(name = "ResourceSpecification_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    private String category;
}
