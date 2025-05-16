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
public class PolicyBase_MVO implements java.io.Serializable {
    private String actionExecutionStrategy;
    private String sequencedActions;
    private Integer priority;
    @OneToMany
    @JoinColumn(name = "PolicyBase_MVO_id")
    @JsonManagedReference
    private List<Reference_MVO> policyDomainRef;
    @OneToMany
    @JoinColumn(name = "PolicyBase_MVO_id")
    @JsonManagedReference
    private List<PolicyEventRelationship_MVO> policyEventRelationship;
    @OneToMany
    @JoinColumn(name = "PolicyBase_MVO_id")
    @JsonManagedReference
    private List<PolicyActionRelationship_MVO> policyActionRelationship;
}
