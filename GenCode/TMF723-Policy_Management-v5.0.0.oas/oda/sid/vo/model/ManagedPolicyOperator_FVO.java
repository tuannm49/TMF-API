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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ManagedPolicyOperator_FVO implements java.io.Serializable {
    private String lifecycleState;
    @OneToMany
    @JoinColumn(name = "ManagedPolicyOperator_FVO_id")
    @JsonManagedReference
    private List<Note_FVO> note;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String name;
    @ManyToOne
    @JoinColumn(name = "variable_id")
    @JsonBackReference
    private PolicyVariableRefOrValue_FVO variable;
    private String description;
    private String version;
}
