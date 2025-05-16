package oda.sid.tmf.model.resource;

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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrossedThresholdInformation implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "threshold_id")
    @JsonBackReference
    private ThresholdRef threshold;
    private String direction;
    private String granularity;
    private String indicatorName;
    private String indicatorUnit;
    private String observedValue;
    private String thresholdCrossingDescription;
}
