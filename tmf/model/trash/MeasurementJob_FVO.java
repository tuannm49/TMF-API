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
public class MeasurementJob_FVO implements java.io.Serializable {
    private OffsetDateTime lastModifiedTime;
    @OneToMany
    @JoinColumn(name = "MeasurementJob_FVO_id")
    @JsonManagedReference
    private List<TrackingRecord_FVO> trackingRecord;
    private OffsetDateTime creationTime;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "executionState_id")
    @JsonBackReference
    private ExecutionStateType executionState;
    private String producingApplicationId;
    @OneToMany
    @JoinColumn(name = "MeasurementJob_FVO_id")
    @JsonManagedReference
    private List<PerformanceIndicatorSpecificationRefOrValue_FVO> performanceIndicatorSpecification;
    @OneToMany
    @JoinColumn(name = "MeasurementJob_FVO_id")
    @JsonManagedReference
    private List<PerformanceIndicatorGroupSpecification_FVO> performanceIndicatorGroupSpecification;
    @OneToMany
    @JoinColumn(name = "MeasurementJob_FVO_id")
    @JsonManagedReference
    private List<FileTransferData_FVO> fileTransferData;
    private String jobId;
    @OneToMany
    @JoinColumn(name = "MeasurementJob_FVO_id")
    @JsonManagedReference
    private List<ScheduleDefinition_FVO> scheduleDefinition;
    @ManyToOne
    @JoinColumn(name = "monitoredClassCriteria_id")
    @JsonBackReference
    private MonitoredClassCriteria_FVO monitoredClassCriteria;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "granularity_id")
    @JsonBackReference
    private Granularity granularity;
    @ManyToOne
    @JoinColumn(name = "monitoredInstancesCriteria_id")
    @JsonBackReference
    private MonitoredInstancesCriteria_FVO monitoredInstancesCriteria;
    @ManyToOne
    @JoinColumn(name = "adminState_id")
    @JsonBackReference
    private AdministrativeState adminState;
    @OneToMany
    @JoinColumn(name = "MeasurementJob_FVO_id")
    @JsonManagedReference
    private List<DataAccessEndpoint_FVO> dataAccessEndpoint;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private Integer jobPriority;
    private String consumingApplicationId;
}
