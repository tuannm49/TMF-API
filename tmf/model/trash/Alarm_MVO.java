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
public class Alarm_MVO implements java.io.Serializable {
    private String reportingSystemId;
    private OffsetDateTime alarmClearedTime;
    private String alarmedObjectType;
    @JsonProperty("@type")
    private String type;
    private String proposedRepairedActions;
    @OneToMany
    @JoinColumn(name = "Alarm_MVO_id")
    @JsonManagedReference
    private List<AlarmRef_MVO> correlatedAlarm;
    private OffsetDateTime alarmReportingTime;
    @ManyToOne
    @JoinColumn(name = "alarmedObject_id")
    @JsonBackReference
    private AlarmedObjectRef_MVO alarmedObject;
    private Boolean alarmEscalation;
    private OffsetDateTime alarmChangedTime;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "perceivedSeverity_id")
    @JsonBackReference
    private PerceivedSeverity perceivedSeverity;
    private String probableCause;
    @OneToMany
    @JoinColumn(name = "Alarm_MVO_id")
    @JsonManagedReference
    private List<ServiceRef_MVO> affectedService;
    private String ackSystemId;
    private String href;
    @Id
    private String id;
    private String state;
    @OneToMany
    @JoinColumn(name = "Alarm_MVO_id")
    @JsonManagedReference
    private List<RelatedPlace_MVO> place;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "crossedThresholdInformation_id")
    @JsonBackReference
    private CrossedThresholdInformation_MVO crossedThresholdInformation;
    private String externalAlarmId;
    private String clearSystemId;
    @OneToMany
    @JoinColumn(name = "Alarm_MVO_id")
    @JsonManagedReference
    private List<AlarmRef_MVO> parentAlarm;
    private Boolean isRootCause;
    private String ackUserId;
    private String clearUserId;
    private Boolean serviceAffecting;
    private String ackState;
    @ManyToOne
    @JoinColumn(name = "alarmType_id")
    @JsonBackReference
    private AlarmType alarmType;
    private String specificProblem;
    @OneToMany
    @JoinColumn(name = "Alarm_MVO_id")
    @JsonManagedReference
    private List<Comment_MVO> comment;
    private String plannedOutageIndicator;
    private String alarmDetails;
}
