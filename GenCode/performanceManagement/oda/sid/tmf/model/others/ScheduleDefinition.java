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
import oda.sid.tmf.model.others.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScheduleDefinition extends Extensible implements java.io.Serializable {
    private List<OffsetDateTime> dateScheduleDefintion;
    private OffsetDateTime scheduleDefinitionEndTime;
    private String recurringFrequency;
    private String scheduleDefinitionHourRange;
    @OneToMany
    @JoinColumn(name = "ScheduleDefinition_id")
    @JsonManagedReference
    private List<DayOfWeekRecurrence> WeeklyScheduledDefinition;
    private List<OffsetDateTime> monthlyScheduleDayOfMonthDefinition;
    @ManyToOne
    @JoinColumn(name = "MonthlyScheduleDayOfWeekDefinition_id")
    @JsonBackReference
    private MonthlyScheduleDayOfWeekDefinition MonthlyScheduleDayOfWeekDefinition;
    private OffsetDateTime scheduleDefinitionStartTime;
    private String id;
    private List<OffsetDateTime> excludedDate;
}
