package oda.sid.vo.model;

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
import oda.sid.vo.model.Entity_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceCategory_MVO extends Entity_MVO implements java.io.Serializable {
    private String lifecycleStatus;
    private Boolean isRoot;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "ResourceCategory_MVO_id")
    @JsonManagedReference
    private List<ResourceSpecificationRef_MVO> resourceSpecification;
    private String description;
    @OneToMany
    @JoinColumn(name = "ResourceCategory_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "ResourceCategory_MVO_id")
    @JsonManagedReference
    private List<ResourceCandidateRef_MVO> resourceCandidate;
    private String parentId;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "ResourceCategory_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ResourceCategory_MVO_id")
    @JsonManagedReference
    private List<ResourceCategoryRef_MVO> category;
}
