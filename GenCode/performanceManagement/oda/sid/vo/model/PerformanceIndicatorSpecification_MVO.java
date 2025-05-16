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
import java.util.List;
import oda.sid.vo.model.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PerformanceIndicatorSpecification_MVO extends Entity implements java.io.Serializable {
    private String derivationAlgorithm;
    @ManyToOne
    @JoinColumn(name = "collectionType_id")
    @JsonBackReference
    private CollectionType collectionType;
    private String derivationMethod;
    @OneToMany
    @JoinColumn(name = "PerformanceIndicatorSpecification_MVO_id")
    @JsonManagedReference
    private List<PerformanceIndicatorSpecRelationship_MVO> performanceIndicatorSpecRelationship;
    @ManyToOne
    @JoinColumn(name = "indicatorType_id")
    @JsonBackReference
    private IndicatorType indicatorType;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String name;
    private String description;
    private String perspective;
    private String indicatorCategory;
    private String indicatorUnit;
}
