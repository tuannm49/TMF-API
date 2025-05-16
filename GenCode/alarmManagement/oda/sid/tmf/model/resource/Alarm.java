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
public class Alarm extends Entity implements java.io.Serializable {
    private String reportingSystemId;
    private OffsetDateTime alarmRaisedTime;
    private OffsetDateTime alarmClearedTime;
    private String alarmedObjectType;
    private String proposedRepairedActions;
    @OneToMany
    @JoinColumn(name = "Alarm_id")
    @JsonManagedReference
    private List<AlarmRef> correlatedAlarm;
    private OffsetDateTime alarmReportingTime;
    @ManyToOne
    @JoinColumn(name = "alarmedObject_id")
    @JsonBackReference
    private AlarmedObjectRef alarmedObject;
    private Boolean alarmEscalation;
    private OffsetDateTime alarmChangedTime;
    @ManyToOne
    @JoinColumn(name = "perceivedSeverity_id")
    @JsonBackReference
    private PerceivedSeverity perceivedSeverity;
    private String probableCause;
    @OneToMany
    @JoinColumn(name = "Alarm_id")
    @JsonManagedReference
    private List<ServiceRef> affectedService;
    private String ackSystemId;
    private String state;
    @OneToMany
    @JoinColumn(name = "Alarm_id")
    @JsonManagedReference
    private List<RelatedPlace> place;
    @ManyToOne
    @JoinColumn(name = "crossedThresholdInformation_id")
    @JsonBackReference
    private CrossedThresholdInformation crossedThresholdInformation;
    private String externalAlarmId;
    private String clearSystemId;
    @OneToMany
    @JoinColumn(name = "Alarm_id")
    @JsonManagedReference
    private List<AlarmRef> parentAlarm;
    private Boolean isRootCause;
    private String ackUserId;
    private String sourceSystemId;
    private String clearUserId;
    private Boolean serviceAffecting;
    private String ackState;
    @ManyToOne
    @JoinColumn(name = "alarmType_id")
    @JsonBackReference
    private AlarmType alarmType;
    private String specificProblem;
    @OneToMany
    @JoinColumn(name = "Alarm_id")
    @JsonManagedReference
    private List<Comment> comment;
    private String plannedOutageIndicator;
    private String alarmDetails;
}
