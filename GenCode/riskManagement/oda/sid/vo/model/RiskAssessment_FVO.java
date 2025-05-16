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
public class RiskAssessment_FVO extends Entity implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "relatedPlace_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue_FVO relatedPlace;
    @ManyToOne
    @JoinColumn(name = "riskAssessmentResult_id")
    @JsonBackReference
    private RiskAssessmentResult riskAssessmentResult;
    @OneToMany
    @JoinColumn(name = "RiskAssessment_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> characteristic;
    private String status;
}
