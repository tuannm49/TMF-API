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
public class Service_MVO extends Entity_MVO implements java.io.Serializable {
    private String serviceType;
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "Service_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    private String serviceDate;
    private OffsetDateTime endDate;
    @OneToMany
    @JoinColumn(name = "Service_MVO_id")
    @JsonManagedReference
    private List<ResourceRef_MVO> supportingResource;
    private Boolean hasStarted;
    private String description;
    @OneToMany
    @JoinColumn(name = "Service_MVO_id")
    @JsonManagedReference
    private List<RelatedServiceOrderItem> serviceOrderItem;
    @OneToMany
    @JoinColumn(name = "Service_MVO_id")
    @JsonManagedReference
    private List<ServiceRelationship> serviceRelationship;
    @OneToMany
    @JoinColumn(name = "Service_MVO_id")
    @JsonManagedReference
    private List<Feature> feature;
    @OneToMany
    @JoinColumn(name = "Service_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "Service_MVO_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue_MVO> place;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ServiceStateType state;
    @ManyToOne
    @JoinColumn(name = "operatingStatus_id")
    @JsonBackReference
    private ServiceOperatingStatusType operatingStatus;
    private Boolean isStateful;
    @OneToMany
    @JoinColumn(name = "Service_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> serviceCharacteristic;
    @OneToMany
    @JoinColumn(name = "Service_MVO_id")
    @JsonManagedReference
    private List<RelatedEntityRefOrValue> relatedEntity;
    @ManyToOne
    @JoinColumn(name = "serviceSpecification_id")
    @JsonBackReference
    private ServiceSpecificationRef serviceSpecification;
    @OneToMany
    @JoinColumn(name = "Service_MVO_id")
    @JsonManagedReference
    private List<ServiceRefOrValue> supportingService;
    @OneToMany
    @JoinColumn(name = "Service_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    @ManyToOne
    @JoinColumn(name = "intent_id")
    @JsonBackReference
    private IntentRefOrValue intent;
    private Boolean isServiceEnabled;
    private String startMode;
    private String name;
    private String category;
    private OffsetDateTime startDate;
}
