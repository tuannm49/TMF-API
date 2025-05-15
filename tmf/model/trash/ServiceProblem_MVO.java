package com.example.trash;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceProblem_MVO implements java.io.Serializable {
    private String statusChangeReason;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    private String reason;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "responsibleParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_MVO responsibleParty;
    private OffsetDateTime resolutionDate;
    private String description;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_MVO_id")
    @JsonManagedReference
    private List<ServiceProblemRef_MVO> underlyingProblem;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> characteristic;
    private OffsetDateTime statusChangeDate;
    @JsonProperty("@baseType")
    private String baseType;
    private String problemEscalation;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_MVO_id")
    @JsonManagedReference
    private List<ServiceRef_MVO> affectedService;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_MVO_id")
    @JsonManagedReference
    private List<ResourceAlarmRef_MVO> underlyingAlarm;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_MVO_id")
    @JsonManagedReference
    private List<ServiceRef_MVO> rootCauseService;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_MVO_id")
    @JsonManagedReference
    private List<RelatedEntity_MVO> relatedEntity;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_MVO_id")
    @JsonManagedReference
    private List<EventRef_MVO> relatedEvent;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_MVO_id")
    @JsonManagedReference
    private List<TroubleTicketRef_MVO> troubleTicket;
    @ManyToOne
    @JoinColumn(name = "originatorParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_MVO originatorParty;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private OffsetDateTime creationDate;
    private Integer priority;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_MVO_id")
    @JsonManagedReference
    private List<ResourceRef_MVO> affectedResource;
    private OffsetDateTime lastUpdate;
    private Integer affectedNumberOfServices;
    private String name;
    private String impactImportanceFactor;
    @ManyToOne
    @JoinColumn(name = "impactPattern_id")
    @JsonBackReference
    private ImpactPattern_MVO impactPattern;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_MVO_id")
    @JsonManagedReference
    private List<ServiceProblemRef_MVO> parentProblem;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_MVO_id")
    @JsonManagedReference
    private List<SLAViolationRef_MVO> slaViolation;
    private String category;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_MVO_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue_MVO> affectedLocation;
    @OneToMany
    @JoinColumn(name = "ServiceProblem_MVO_id")
    @JsonManagedReference
    private List<ResourceRef_MVO> rootCauseResource;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private ServiceProblemStateType status;
}
