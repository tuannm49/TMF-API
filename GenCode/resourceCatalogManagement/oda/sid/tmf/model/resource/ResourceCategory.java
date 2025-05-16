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
public class ResourceCategory extends Entity implements java.io.Serializable {
    private String lifecycleStatus;
    private Boolean isRoot;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "ResourceCategory_id")
    @JsonManagedReference
    private List<ResourceSpecificationRef> resourceSpecification;
    private String description;
    @OneToMany
    @JoinColumn(name = "ResourceCategory_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "ResourceCategory_id")
    @JsonManagedReference
    private List<ResourceCandidateRef> resourceCandidate;
    private String parentId;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "ResourceCategory_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ResourceCategory_id")
    @JsonManagedReference
    private List<ResourceCategoryRef> category;
}
