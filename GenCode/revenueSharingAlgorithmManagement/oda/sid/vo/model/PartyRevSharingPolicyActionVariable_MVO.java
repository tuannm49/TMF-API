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
import oda.sid.vo.model.Entity_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyRevSharingPolicyActionVariable_MVO extends Entity_MVO implements java.io.Serializable {
    private String value;
    @ManyToOne
    @JoinColumn(name = "policyAction_id")
    @JsonBackReference
    private PolicyActionRef_MVO policyAction;
    @ManyToOne
    @JoinColumn(name = "policyActionVariable_id")
    @JsonBackReference
    private PolicyVariableRef_MVO policyActionVariable;
}
