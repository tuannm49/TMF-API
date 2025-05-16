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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Alarm implements java.io.Serializable {
    @Id
    private Integer id;
    private String href;
    private String ackState;
    private String ackSystemId;
    private String ackUserId;
    private OffsetDateTime alarmChangedTime;
    private OffsetDateTime alarmClearedTime;
    private String alarmDetails;
    private Boolean alarmEscalation;
    private OffsetDateTime alarmRaisedTime;
    private OffsetDateTime alarmReportingTime;
    private String alarmType;
    private String alarmedObjectType;
    private String clearSystemId;
    private String clearUserId;
    private String externalAlarmId;
    private Boolean isRootCause;
    private String perceivedSeverity;
    private String plannedOutageIndicator;
    private String probableCause;
    private String proposedRepairedActions;
    private String reportingSystemId;
    private Boolean serviceAffecting;
    private String sourceSystemId;
    private String specificProblem;
    private String state;
    @OneToMany
    @JoinColumn(name = "Alarm_id")
    @JsonManagedReference
    private List<AffectedService> affectedService;
    @ManyToOne
    @JoinColumn(name = "alarmedObject_id")
    @JsonBackReference
    private AlarmedObject alarmedObject;
    @OneToMany
    @JoinColumn(name = "Alarm_id")
    @JsonManagedReference
    private List<Comment> comment;
    @OneToMany
    @JoinColumn(name = "Alarm_id")
    @JsonManagedReference
    private List<AlarmRef> correlatedAlarm;
    @ManyToOne
    @JoinColumn(name = "crossedThresholdInformation_id")
    @JsonBackReference
    private CrossedThresholdInformation crossedThresholdInformation;
    @OneToMany
    @JoinColumn(name = "Alarm_id")
    @JsonManagedReference
    private List<AlarmRef> parentAlarm;
    @OneToMany
    @JoinColumn(name = "Alarm_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue> place;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
