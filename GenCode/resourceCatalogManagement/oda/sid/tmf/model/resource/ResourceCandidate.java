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
public class ResourceCandidate extends Entity implements java.io.Serializable {
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private OffsetDateTime lastUpdate;
    @ManyToOne
    @JoinColumn(name = "resourceSpecification_id")
    @JsonBackReference
    private ResourceSpecificationRef resourceSpecification;
    private String description;
    @OneToMany
    @JoinColumn(name = "ResourceCandidate_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ResourceCandidate_id")
    @JsonManagedReference
    private List<ResourceCategoryRef> category;
    private String version;
}
