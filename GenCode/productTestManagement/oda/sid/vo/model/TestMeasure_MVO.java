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
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.vo.model.Extensible_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestMeasure_MVO extends Extensible_MVO implements java.io.Serializable {
    private String metricDescription;
    private String metricName;
    private String unitOfMeasure;
    private OffsetDateTime captureDateTime;
    private Object accuracy;
    private String captureMethod;
    @OneToMany
    @JoinColumn(name = "TestMeasure_MVO_id")
    @JsonManagedReference
    private List<MeasureThresholdRuleViolation_MVO> ruleViolation;
    private String metricHref;
    @ManyToOne
    @JoinColumn(name = "value_id")
    @JsonBackReference
    private Characteristic_MVO value;
    @OneToMany
    @JoinColumn(name = "TestMeasure_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> testMeasureCharacteristic;
}
