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
public class TestMeasureDefinition extends Extensible implements java.io.Serializable {
    private String metricDescription;
    private String metricName;
    private String unitOfMeasure;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
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
    @JoinColumn(name = "TestMeasureDefinition_id")
    @JsonManagedReference
    private List<MetricDefMeasureThresholdRule> thresholdRule;
}
