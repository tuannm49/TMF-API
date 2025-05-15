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
public class ScheduleDefinition_MVO implements java.io.Serializable {
    private List<OffsetDateTime> dateScheduleDefintion;
    private String recurringFrequency;
    private String scheduleDefinitionHourRange;
    @OneToMany
    @JoinColumn(name = "ScheduleDefinition_MVO_id")
    @JsonManagedReference
    private List<DayOfWeekRecurrence_MVO> WeeklyScheduledDefinition;
    @JsonProperty("@type")
    private String type;
    private OffsetDateTime scheduleDefinitionEndTime;
    @JsonProperty("@baseType")
    private String baseType;
    private List<OffsetDateTime> monthlyScheduleDayOfMonthDefinition;
    @ManyToOne
    @JoinColumn(name = "MonthlyScheduleDayOfWeekDefinition_id")
    @JsonBackReference
    private MonthlyScheduleDayOfWeekDefinition_MVO MonthlyScheduleDayOfWeekDefinition;
    private OffsetDateTime scheduleDefinitionStartTime;
    @Id
    private String id;
    private List<OffsetDateTime> excludedDate;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
