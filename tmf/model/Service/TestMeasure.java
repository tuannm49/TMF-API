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
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestMeasure implements java.io.Serializable {
    private String metricDescription;
    private String metricName;
    @JsonProperty("@baseType")
    private String baseType;
    private String unitOfMeasure;
    private OffsetDateTime captureDateTime;
    @JsonProperty("@type")
    private String type;
    private Object accuracy;
    private String captureMethod;
    @OneToMany
    @JoinColumn(name = "TestMeasure_id")
    @JsonManagedReference
    private List<MeasureThresholdRuleViolation> ruleViolation;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String metricHref;
    @ManyToOne
    @JoinColumn(name = "value_id")
    @JsonBackReference
    private Characteristic value;
}
