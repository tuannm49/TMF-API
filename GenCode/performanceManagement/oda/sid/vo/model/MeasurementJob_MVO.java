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
import oda.sid.vo.model.ManagementJob_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MeasurementJob_MVO extends ManagementJob_MVO implements java.io.Serializable {
    private String producingApplicationId;
    @OneToMany
    @JoinColumn(name = "MeasurementJob_MVO_id")
    @JsonManagedReference
    private List<TrackingRecord_MVO> trackingRecord;
    @OneToMany
    @JoinColumn(name = "MeasurementJob_MVO_id")
    @JsonManagedReference
    private List<PerformanceIndicatorSpecificationRefOrValue_MVO> performanceIndicatorSpecification;
    private String consumingApplicationId;
    @ManyToOne
    @JoinColumn(name = "granularity_id")
    @JsonBackReference
    private Granularity granularity;
    @OneToMany
    @JoinColumn(name = "MeasurementJob_MVO_id")
    @JsonManagedReference
    private List<PerformanceIndicatorGroupSpecification_MVO> performanceIndicatorGroupSpecification;
}
