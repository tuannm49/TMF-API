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
public class MeasurementCollectionJob_FVO implements java.io.Serializable {
    private OffsetDateTime lastModifiedTime;
    @OneToMany
    @JoinColumn(name = "MeasurementCollectionJob_FVO_id")
    @JsonManagedReference
    private List<TrackingRecord_FVO> trackingRecord;
    private OffsetDateTime creationTime;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "jobCollectionFilter_id")
    @JsonBackReference
    private DataFilterMap_FVO jobCollectionFilter;
    @ManyToOne
    @JoinColumn(name = "searchTaskFilter_id")
    @JsonBackReference
    private DataFilterMap_FVO searchTaskFilter;
    private String producingApplicationId;
    @OneToMany
    @JoinColumn(name = "MeasurementCollectionJob_FVO_id")
    @JsonManagedReference
    private List<PerformanceIndicatorGroupSpecification_FVO> performanceIndicatorGroupSpecification;
    @OneToMany
    @JoinColumn(name = "MeasurementCollectionJob_FVO_id")
    @JsonManagedReference
    private List<ScheduleDefinition_FVO> scheduleDefinition;
    @ManyToOne
    @JoinColumn(name = "monitoredClassCriteria_id")
    @JsonBackReference
    private MonitoredClassCriteria_FVO monitoredClassCriteria;
    @JsonProperty("@baseType")
    private String baseType;
    private Boolean jobOnDemand;
    @ManyToOne
    @JoinColumn(name = "adminState_id")
    @JsonBackReference
    private AdministrativeState adminState;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String outputFormat;
    private Integer jobPriority;
    private String consumingApplicationId;
    @ManyToOne
    @JoinColumn(name = "reportingPeriod_id")
    @JsonBackReference
    private ReportingPeriod reportingPeriod;
    @ManyToOne
    @JoinColumn(name = "executionState_id")
    @JsonBackReference
    private ExecutionStateType executionState;
    @OneToMany
    @JoinColumn(name = "MeasurementCollectionJob_FVO_id")
    @JsonManagedReference
    private List<PerformanceIndicatorSpecificationRefOrValue_FVO> performanceIndicatorSpecification;
    @OneToMany
    @JoinColumn(name = "MeasurementCollectionJob_FVO_id")
    @JsonManagedReference
    private List<FileTransferData_FVO> fileTransferData;
    private String jobId;
    @ManyToOne
    @JoinColumn(name = "granularity_id")
    @JsonBackReference
    private Granularity granularity;
    @ManyToOne
    @JoinColumn(name = "monitoredInstancesCriteria_id")
    @JsonBackReference
    private MonitoredInstancesCriteria_FVO monitoredInstancesCriteria;
    @OneToMany
    @JoinColumn(name = "MeasurementCollectionJob_FVO_id")
    @JsonManagedReference
    private List<DataAccessEndpoint_FVO> dataAccessEndpoint;
}
