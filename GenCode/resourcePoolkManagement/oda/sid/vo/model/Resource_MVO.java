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
public class Resource_MVO extends Entity_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Resource_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private OffsetDateTime endOperatingDate;
    @OneToMany
    @JoinColumn(name = "Resource_MVO_id")
    @JsonManagedReference
    private List<ResourceRefOrValue_MVO> supportingResource;
    private String resourceVersion;
    @OneToMany
    @JoinColumn(name = "Resource_MVO_id")
    @JsonManagedReference
    private List<Feature_MVO> activationFeature;
    @ManyToOne
    @JoinColumn(name = "resourceSpecification_id")
    @JsonBackReference
    private ResourceSpecificationRef_MVO resourceSpecification;
    private String description;
    @OneToMany
    @JoinColumn(name = "Resource_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> resourceCharacteristic;
    @OneToMany
    @JoinColumn(name = "Resource_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    @ManyToOne
    @JoinColumn(name = "intent_id")
    @JsonBackReference
    private IntentRef_MVO intent;
    @ManyToOne
    @JoinColumn(name = "resourceStatus_id")
    @JsonBackReference
    private ResourceStatusType resourceStatus;
    @ManyToOne
    @JoinColumn(name = "usageState_id")
    @JsonBackReference
    private ResourceUsageStateType usageState;
    @OneToMany
    @JoinColumn(name = "Resource_MVO_id")
    @JsonManagedReference
    private List<AttachmentRef_MVO> attachment;
    @ManyToOne
    @JoinColumn(name = "administrativeState_id")
    @JsonBackReference
    private ResourceAdministrativeStateType administrativeState;
    private String name;
    @OneToMany
    @JoinColumn(name = "Resource_MVO_id")
    @JsonManagedReference
    private List<RelatedResourceOrderItem_MVO> resourceOrderItem;
    @OneToMany
    @JoinColumn(name = "Resource_MVO_id")
    @JsonManagedReference
    private List<ResourceRelationship_MVO> resourceRelationship;
    @OneToMany
    @JoinColumn(name = "Resource_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @ManyToOne
    @JoinColumn(name = "operationalState_id")
    @JsonBackReference
    private ResourceOperationalStateType operationalState;
    @OneToMany
    @JoinColumn(name = "Resource_MVO_id")
    @JsonManagedReference
    private List<RelatedPlaceRef_MVO> place;
    private OffsetDateTime startOperatingDate;
    private String category;
}
