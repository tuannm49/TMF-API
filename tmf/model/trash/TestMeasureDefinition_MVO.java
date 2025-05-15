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
public class TestMeasureDefinition_MVO implements java.io.Serializable {
    private String metricDescription;
    private String metricName;
    private String unitOfMeasure;
    private String valueType;
    private String name;
    private String captureMethod;
    private String captureFrequency;
    @ManyToOne
    @JoinColumn(name = "capturePeriod_id")
    @JsonBackReference
    private Duration capturePeriod;
    private String metricHref;
    @OneToMany
    @JoinColumn(name = "TestMeasureDefinition_MVO_id")
    @JsonManagedReference
    private List<MetricDefMeasureThresholdRule_MVO> thresholdRule;
}
