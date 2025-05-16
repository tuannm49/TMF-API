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
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.tmf.model.service.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestMeasure extends Extensible implements java.io.Serializable {
    private String metricDescription;
    private String metricName;
    private String unitOfMeasure;
    private OffsetDateTime captureDateTime;
    private Object accuracy;
    private String captureMethod;
    @OneToMany
    @JoinColumn(name = "TestMeasure_id")
    @JsonManagedReference
    private List<MeasureThresholdRuleViolation> ruleViolation;
    private String metricHref;
    @ManyToOne
    @JoinColumn(name = "value_id")
    @JsonBackReference
    private Characteristic value;
}
