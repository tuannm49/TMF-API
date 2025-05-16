package oda.sid.tmf.model.service;

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
import oda.sid.tmf.model.service.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceProblem extends Entity implements java.io.Serializable {
    private String statusChangeReason;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<Note> note;
    private String reason;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<TrackingRecord> trackingRecord;
    @ManyToOne
    @JoinColumn(name = "responsibleParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef responsibleParty;
    private OffsetDateTime resolutionDate;
    private String description;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<ServiceProblemRef> underlyingProblem;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    private OffsetDateTime statusChangeDate;
    private String problemEscalation;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<ServiceRef> affectedService;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<ResourceAlarmRef> underlyingAlarm;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<ServiceRef> rootCauseService;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<RelatedEntity> relatedEntity;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<ErrorMessage> errorMessage;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<EventRef> relatedEvent;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<TroubleTicketRef> troubleTicket;
    @ManyToOne
    @JoinColumn(name = "originatorParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef originatorParty;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    private OffsetDateTime creationDate;
    private Integer priority;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<ResourceRef> affectedResource;
    @ManyToOne
    @JoinColumn(name = "firstAlert_id")
    @JsonBackReference
    private RelatedEntity firstAlert;
    private String originatingSystem;
    private OffsetDateTime lastUpdate;
    private Integer affectedNumberOfServices;
    private String name;
    private String impactImportanceFactor;
    @ManyToOne
    @JoinColumn(name = "impactPattern_id")
    @JsonBackReference
    private ImpactPattern impactPattern;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<ServiceProblemRef> parentProblem;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<SLAViolationRef> slaViolation;
    private String category;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue> affectedLocation;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_id")
    @JsonManagedReference
    private List<ResourceRef> rootCauseResource;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private ServiceProblemStateType status;
}
