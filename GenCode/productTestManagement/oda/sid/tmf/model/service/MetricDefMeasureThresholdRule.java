package oda.sid.tmf.model.service;

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
import oda.sid.tmf.model.service.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricDefMeasureThresholdRule extends Extensible implements java.io.Serializable {
    private Boolean conformanceComparatorExact;
    @OneToMany
    @JoinColumn(name = "MetricDefMeasureThresholdRule_id")
    @JsonManagedReference
    private List<MetricDefMeasureConsequence> consequence;
    private String conformanceComparatorLower;
    private String conformanceComparatorUpper;
    @ManyToOne
    @JoinColumn(name = "tolerancePeriod_id")
    @JsonBackReference
    private Duration tolerancePeriod;
    private Integer numberOfAllowedCrossing;
    private String conformanceTargetUpper;
    private String name;
    private String description;
    private String thresholdRuleSeverity;
    private String conformanceTargetLower;
    private String conformanceTargetExact;
}
