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
public class PerformanceIndicatorSpecification_MVO implements java.io.Serializable {
    private String derivationAlgorithm;
    @OneToMany
    @JoinColumn(name = "PerformanceIndicatorSpecification_MVO_id")
    @JsonManagedReference
    private List<PerformanceIndicatorSpecRelationship_MVO> performanceIndicatorSpecRelationship;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String description;
    private String indicatorUnit;
    @ManyToOne
    @JoinColumn(name = "collectionType_id")
    @JsonBackReference
    private CollectionType collectionType;
    private String derivationMethod;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "indicatorType_id")
    @JsonBackReference
    private IndicatorType indicatorType;
    private String name;
    private String perspective;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String indicatorCategory;
}
