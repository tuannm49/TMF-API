package oda.sid.tmf.model.others;

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
import oda.sid.tmf.model.others.MeasurementJob;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MeasurementCollectionJob extends MeasurementJob implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "jobCollectionFilter_id")
    @JsonBackReference
    private DataFilterMap jobCollectionFilter;
    @ManyToOne
    @JoinColumn(name = "searchTaskFilter_id")
    @JsonBackReference
    private DataFilterMap searchTaskFilter;
    @ManyToOne
    @JoinColumn(name = "reportingPeriod_id")
    @JsonBackReference
    private ReportingPeriod reportingPeriod;
    private String outputFormat;
    private Boolean jobOnDemand;
}
