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
import oda.sid.vo.model.EntitySpecification_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntentSpecification_MVO extends EntitySpecification_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "expressionSpecification_id")
    @JsonBackReference
    private ExpressionSpecification_MVO expressionSpecification;
    @OneToMany
    @JoinColumn(name = "IntentSpecification_MVO_id")
    @JsonManagedReference
    private List<IntentSpecificationRelationship_MVO> intentSpecRelationship;
    private String version;
}
