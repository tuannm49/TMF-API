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
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.vo.model.Activity_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClosedLoopWorkflowActivity_MVO extends Activity_MVO implements java.io.Serializable {
    private String name;
    private String description;
    private OffsetDateTime creationdate;
    private OffsetDateTime validfor;
    @OneToMany
    @JoinColumn(name = "ClosedLoopWorkflowActivity_MVO_id")
    @JsonManagedReference
    private List<ActivityRelationship_MVO> activity;
}
