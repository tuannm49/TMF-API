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
public class TestMeasureDefinition implements java.io.Serializable {
    private String metricName;
    private String unitOfMeasure;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String captureFrequency;
    private String metricHref;
    private String metricDescription;
    @JsonProperty("@baseType")
    private String baseType;
    private String valueType;
    private String name;
    private String captureMethod;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "capturePeriod_id")
    @JsonBackReference
    private Duration capturePeriod;
    @OneToMany
    @JoinColumn(name = "TestMeasureDefinition_id")
    @JsonManagedReference
    private List<MetricDefMeasureThresholdRule> thresholdRule;
}
