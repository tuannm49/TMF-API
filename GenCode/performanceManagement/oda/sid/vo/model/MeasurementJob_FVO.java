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
import java.util.List;
import oda.sid.vo.model.ManagementJob_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MeasurementJob_FVO extends ManagementJob_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "MeasurementJob_FVO_id")
    @JsonManagedReference
    private List<TrackingRecord_FVO> trackingRecord;
    @ManyToOne
    @JoinColumn(name = "monitoredClassCriteria_id")
    @JsonBackReference
    private MonitoredClassCriteria_FVO monitoredClassCriteria;
    @ManyToOne
    @JoinColumn(name = "granularity_id")
    @JsonBackReference
    private Granularity granularity;
    @ManyToOne
    @JoinColumn(name = "monitoredInstancesCriteria_id")
    @JsonBackReference
    private MonitoredInstancesCriteria_FVO monitoredInstancesCriteria;
    private String producingApplicationId;
    @OneToMany
    @JoinColumn(name = "MeasurementJob_FVO_id")
    @JsonManagedReference
    private List<PerformanceIndicatorSpecificationRefOrValue_FVO> performanceIndicatorSpecification;
    private String consumingApplicationId;
    @OneToMany
    @JoinColumn(name = "MeasurementJob_FVO_id")
    @JsonManagedReference
    private List<PerformanceIndicatorGroupSpecification_FVO> performanceIndicatorGroupSpecification;
}
