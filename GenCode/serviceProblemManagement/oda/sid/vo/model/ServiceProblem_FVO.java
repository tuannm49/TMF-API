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
public class ServiceProblem_FVO extends Entity_FVO implements java.io.Serializable {
    private String statusChangeReason;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<Note_FVO> note;
    private String reason;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<TrackingRecord_FVO> trackingRecord;
    @ManyToOne
    @JoinColumn(name = "responsibleParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_FVO responsibleParty;
    private OffsetDateTime resolutionDate;
    private String description;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<ServiceProblemRef_FVO> underlyingProblem;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> characteristic;
    private OffsetDateTime statusChangeDate;
    private String problemEscalation;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<ServiceRef_FVO> affectedService;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<ResourceAlarmRef_FVO> underlyingAlarm;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<ServiceRef_FVO> rootCauseService;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<RelatedEntity_FVO> relatedEntity;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<EventRef_FVO> relatedEvent;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<TroubleTicketRef_FVO> troubleTicket;
    @ManyToOne
    @JoinColumn(name = "originatorParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_FVO originatorParty;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    private OffsetDateTime creationDate;
    private Integer priority;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<ResourceRef_FVO> affectedResource;
    @ManyToOne
    @JoinColumn(name = "firstAlert_id")
    @JsonBackReference
    private RelatedEntity_FVO firstAlert;
    private String originatingSystem;
    private OffsetDateTime lastUpdate;
    private Integer affectedNumberOfServices;
    private String name;
    private String impactImportanceFactor;
    @ManyToOne
    @JoinColumn(name = "impactPattern_id")
    @JsonBackReference
    private ImpactPattern_FVO impactPattern;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<ServiceProblemRef_FVO> parentProblem;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<SLAViolationRef_FVO> slaViolation;
    private String category;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue_FVO> affectedLocation;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_FVO_id")
    @JsonManagedReference
    private List<ResourceRef_FVO> rootCauseResource;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private ServiceProblemStateType status;
}
