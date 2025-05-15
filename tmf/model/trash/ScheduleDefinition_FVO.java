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
public class ScheduleDefinition_FVO implements java.io.Serializable {
    private List<OffsetDateTime> dateScheduleDefintion;
    private OffsetDateTime scheduleDefinitionEndTime;
    private String recurringFrequency;
    private String scheduleDefinitionHourRange;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "ScheduleDefinition_FVO_id")
    @JsonManagedReference
    private List<DayOfWeekRecurrence_FVO> WeeklyScheduledDefinition;
    private List<OffsetDateTime> monthlyScheduleDayOfMonthDefinition;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "MonthlyScheduleDayOfWeekDefinition_id")
    @JsonBackReference
    private MonthlyScheduleDayOfWeekDefinition_FVO MonthlyScheduleDayOfWeekDefinition;
    private OffsetDateTime scheduleDefinitionStartTime;
    private List<OffsetDateTime> excludedDate;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
