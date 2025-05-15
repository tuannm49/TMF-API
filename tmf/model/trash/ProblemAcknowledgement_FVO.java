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
public class ProblemAcknowledgement_FVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "trackingRecord_id")
    @JsonBackReference
    private TrackingRecord_FVO trackingRecord;
    @OneToMany
    @JoinColumn(name = "ProblemAcknowledgement_FVO_id")
    @JsonManagedReference
    private List<ServiceProblemRef_FVO> problem;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "ProblemAcknowledgement_FVO_id")
    @JsonManagedReference
    private List<ServiceProblemRef_FVO> ackProblem;
    private String state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
