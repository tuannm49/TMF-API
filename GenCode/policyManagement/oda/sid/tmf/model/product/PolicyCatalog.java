package oda.sid.tmf.model.product;

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
import oda.sid.tmf.model.product.PolicyManagedEntity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyCatalog extends PolicyManagedEntity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<ManagedPolicyExpression> policyExpression;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<ManagedPolicyAction> policyAction;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<Reference> policyDomainFilter;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<ManagedPolicyCondition> policyCondition;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<ManagedPolicyConstraint> policyConstraint;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<ManagedPolicyVariable> policyVariable;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<ManagedPolicyOperator> policyOperator;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<ManagedPolicy> policy;
    @OneToMany
    @JoinColumn(name = "PolicyCatalog_id")
    @JsonManagedReference
    private List<ManagedPolicyEvent> policyEvent;
}
