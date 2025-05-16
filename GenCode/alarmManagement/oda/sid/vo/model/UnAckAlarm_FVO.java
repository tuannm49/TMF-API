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
import oda.sid.vo.model.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UnAckAlarm_FVO extends Entity implements java.io.Serializable {
    private OffsetDateTime ackTime;
    private String ackUserId;
    @OneToMany
    @JoinColumn(name = "UnAckAlarm_FVO_id")
    @JsonManagedReference
    private List<AlarmRefOrValue> unAckedAlarm;
    @OneToMany
    @JoinColumn(name = "UnAckAlarm_FVO_id")
    @JsonManagedReference
    private List<AlarmRefOrValue> alarmPattern;
    private String ackSystemId;
    private String id;
    private String href;
    private String state;
}
