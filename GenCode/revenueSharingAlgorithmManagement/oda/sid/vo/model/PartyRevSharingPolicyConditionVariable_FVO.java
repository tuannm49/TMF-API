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
import oda.sid.vo.model.Entity_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyRevSharingPolicyConditionVariable_FVO extends Entity_FVO implements java.io.Serializable {
    private String value;
    @ManyToOne
    @JoinColumn(name = "policyCondition_id")
    @JsonBackReference
    private PolicyConditionRef_FVO policyCondition;
    @ManyToOne
    @JoinColumn(name = "policyConditionVariable_id")
    @JsonBackReference
    private PolicyVariableRef_FVO policyConditionVariable;
}
