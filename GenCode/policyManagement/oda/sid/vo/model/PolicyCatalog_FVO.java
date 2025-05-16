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
import oda.sid.vo.model.PolicyManagedEntity_FVO_FVO_FVO_FVO_FVO_FVO_FVO_FVO_FVO_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyCatalog_FVO extends PolicyManagedEntity_FVO_FVO_FVO_FVO_FVO_FVO_FVO_FVO_FVO_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<ManagedPolicyExpression_FVO> policyExpression;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<ManagedPolicyAction_FVO> policyAction;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<Reference_FVO_FVO_FVO_FVO_FVO> policyDomainFilter;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<ManagedPolicyCondition_FVO> policyCondition;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<ManagedPolicyConstraint_FVO> policyConstraint;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<ManagedPolicyVariable_FVO> policyVariable;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<ManagedPolicyOperator_FVO> policyOperator;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<ManagedPolicy_FVO> policy;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_FVO_id")
    @JsonManagedReference
    private List<ManagedPolicyEvent_FVO> policyEvent;
}
