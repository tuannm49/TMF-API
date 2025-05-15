package com.example.Service;

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
public class MetricDefMeasureThresholdRule implements java.io.Serializable {
    private Boolean conformanceComparatorExact;
    @OneToMany
    @JoinColumn(name = "MetricDefMeasureThresholdRule_id")
    @JsonManagedReference
    private List<MetricDefMeasureConsequence> consequence;
    private String conformanceComparatorLower;
    private String conformanceComparatorUpper;
    @JsonProperty("@type")
    private String type;
    private String description;
    private String thresholdRuleSeverity;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "tolerancePeriod_id")
    @JsonBackReference
    private Duration tolerancePeriod;
    private Integer numberOfAllowedCrossing;
    private String conformanceTargetUpper;
    private String name;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String conformanceTargetLower;
    private String conformanceTargetExact;
}
