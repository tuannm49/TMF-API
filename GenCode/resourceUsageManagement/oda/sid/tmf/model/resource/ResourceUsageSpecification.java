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
public class ResourceUsageSpecification extends Entity implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "ResourceUsageSpecification_id")
    @JsonManagedReference
    private List<ResourceUsageSpecificationRef> bundledResourceUsageSpecification;
    private String lifecycleStatus;
    @OneToMany
    @JoinColumn(name = "ResourceUsageSpecification_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "ResourceUsageSpecification_id")
    @JsonManagedReference
    private List<ResourceSpecificationRef> resourceSpecification;
    @OneToMany
    @JoinColumn(name = "ResourceUsageSpecification_id")
    @JsonManagedReference
    private List<ResourceUsageSpecRelationship> resourceUsageSpecRelationship;
    private String description;
    @OneToMany
    @JoinColumn(name = "ResourceUsageSpecification_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> specCharacteristic;
    private String version;
}
