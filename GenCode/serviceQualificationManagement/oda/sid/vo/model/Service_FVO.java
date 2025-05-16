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
import oda.sid.vo.model.Entity_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Service_FVO extends Entity_FVO implements java.io.Serializable {
    private String serviceType;
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<Note_FVO> note;
    private String serviceDate;
    private OffsetDateTime endDate;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<ResourceRef_FVO> supportingResource;
    private Boolean hasStarted;
    private String description;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<RelatedServiceOrderItem_FVO> serviceOrderItem;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<ServiceRelationship_FVO> serviceRelationship;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<Feature_FVO> feature;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue_FVO> place;
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
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> serviceCharacteristic;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<RelatedEntityRefOrValue_FVO> relatedEntity;
    @ManyToOne
    @JoinColumn(name = "serviceSpecification_id")
    @JsonBackReference
    private ServiceSpecificationRef_FVO serviceSpecification;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<ServiceRefOrValue_FVO> supportingService;
    @OneToMany
    @JoinColumn(name = "Service_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    @ManyToOne
    @JoinColumn(name = "intent_id")
    @JsonBackReference
    private IntentRefOrValue_FVO intent;
    private Boolean isServiceEnabled;
    private String startMode;
    private String name;
    private String category;
    private OffsetDateTime startDate;
}
