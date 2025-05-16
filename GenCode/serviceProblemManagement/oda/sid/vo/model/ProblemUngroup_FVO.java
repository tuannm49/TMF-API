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
import oda.sid.vo.model.Entity_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProblemUngroup_FVO extends Entity_FVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "parentProblem_id")
    @JsonBackReference
    private ServiceProblemRef_FVO parentProblem;
    @OneToMany
    @JoinColumn(name = "ProblemUngroup_FVO_id")
    @JsonManagedReference
    private List<ServiceProblemRef_FVO> childProblem;
    private String state;
}
