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
import oda.sid.tmf.model.service.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProblemAcknowledgement extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ProblemAcknowledgement_id")
    @JsonManagedReference
    private List<ServiceProblemRef> ackProblem;
    @ManyToOne
    @JoinColumn(name = "trackingRecord_id")
    @JsonBackReference
    private TrackingRecord trackingRecord;
    @OneToMany
    @JoinColumn(name = "ProblemAcknowledgement_id")
    @JsonManagedReference
    private List<ServiceProblemRef> problem;
    private String state;
}
