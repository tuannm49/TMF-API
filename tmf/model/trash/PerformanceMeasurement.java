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
public class PerformanceMeasurement implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "measurementCollectionJob_id")
    @JsonBackReference
    private MeasurementCollectionJobRef measurementCollectionJob;
    private String description;
    private String href;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "PerformanceMeasurement_id")
    @JsonManagedReference
    private List<PerformanceMeasurementRelationship> relatedMeasurement;
    private Object tag;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
