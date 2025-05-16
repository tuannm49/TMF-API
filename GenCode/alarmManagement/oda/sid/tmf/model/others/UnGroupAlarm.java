package oda.sid.tmf.model.others;

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
import oda.sid.tmf.model.others.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UnGroupAlarm extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "UnGroupAlarm_id")
    @JsonManagedReference
    private List<AlarmRefOrValue> unGroupedAlarm;
    private String sourceSystemId;
    @OneToMany
    @JoinColumn(name = "UnGroupAlarm_id")
    @JsonManagedReference
    private List<AlarmRefOrValue> correlatedAlarm;
    private String id;
    private String href;
    private String state;
    private OffsetDateTime alarmChangedTime;
    @ManyToOne
    @JoinColumn(name = "parentAlarm_id")
    @JsonBackReference
    private AlarmRefOrValue parentAlarm;
}
