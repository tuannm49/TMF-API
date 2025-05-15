package com.example.Resource;

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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrossedThresholdInformation implements java.io.Serializable {
    private String indicatorName;
    private String thresholdCrossingDescription;
    private String granularity;
    private String observedValue;
    @ManyToOne
    @JoinColumn(name = "threshold_id")
    @JsonBackReference
    private ThresholdRef threshold;
    private String direction;
    private String indicatorUnit;
}
