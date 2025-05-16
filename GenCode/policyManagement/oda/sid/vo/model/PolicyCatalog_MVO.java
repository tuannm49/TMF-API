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
import oda.sid.vo.model.PolicyManagedEntity_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyCatalog_MVO extends PolicyManagedEntity_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<ManagedPolicyExpression_MVO> policyExpression;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<ManagedPolicyAction_MVO> policyAction;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<Reference_MVO> policyDomainFilter;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<ManagedPolicyCondition_MVO> policyCondition;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<ManagedPolicyConstraint_MVO> policyConstraint;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<ManagedPolicyVariable_MVO> policyVariable;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<ManagedPolicyOperator_MVO> policyOperator;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<ManagedPolicy_MVO> policy;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_MVO_id")
    @JsonManagedReference
    private List<ManagedPolicyEvent_MVO> policyEvent;
}
