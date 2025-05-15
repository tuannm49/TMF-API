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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MeasurementCollectionJob_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "MeasurementCollectionJob_MVO_id")
    @JsonManagedReference
    private List<TrackingRecord_MVO> trackingRecord;
    @ManyToOne
    @JoinColumn(name = "reportingPeriod_id")
    @JsonBackReference
    private ReportingPeriod reportingPeriod;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "jobCollectionFilter_id")
    @JsonBackReference
    private DataFilterMap_MVO jobCollectionFilter;
    @ManyToOne
    @JoinColumn(name = "searchTaskFilter_id")
    @JsonBackReference
    private DataFilterMap_MVO searchTaskFilter;
    private String producingApplicationId;
    @OneToMany
    @JoinColumn(name = "MeasurementCollectionJob_MVO_id")
    @JsonManagedReference
    private List<PerformanceIndicatorSpecificationRefOrValue_MVO> performanceIndicatorSpecification;
    @OneToMany
    @JoinColumn(name = "MeasurementCollectionJob_MVO_id")
    @JsonManagedReference
    private List<PerformanceIndicatorGroupSpecification_MVO> performanceIndicatorGroupSpecification;
    @OneToMany
    @JoinColumn(name = "MeasurementCollectionJob_MVO_id")
    @JsonManagedReference
    private List<FileTransferData_MVO> fileTransferData;
    @OneToMany
    @JoinColumn(name = "MeasurementCollectionJob_MVO_id")
    @JsonManagedReference
    private List<ScheduleDefinition_MVO> scheduleDefinition;
    @JsonProperty("@baseType")
    private String baseType;
    private Boolean jobOnDemand;
    @ManyToOne
    @JoinColumn(name = "granularity_id")
    @JsonBackReference
    private Granularity granularity;
    @OneToMany
    @JoinColumn(name = "MeasurementCollectionJob_MVO_id")
    @JsonManagedReference
    private List<DataAccessEndpoint_MVO> dataAccessEndpoint;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String outputFormat;
    private String consumingApplicationId;
}
