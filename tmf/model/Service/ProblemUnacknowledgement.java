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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProblemUnacknowledgement implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "trackingRecord_id")
    @JsonBackReference
    private TrackingRecord trackingRecord;
    @OneToMany
    @JoinColumn(name = "ProblemUnacknowledgement_id")
    @JsonManagedReference
    private List<ServiceProblemRef> problem;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    private String href;
    @Id
    private String id;
    private String state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "ProblemUnacknowledgement_id")
    @JsonManagedReference
    private List<ServiceProblemRef> unackProblem;
}
