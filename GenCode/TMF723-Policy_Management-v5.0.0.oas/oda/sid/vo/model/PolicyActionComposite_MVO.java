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
import oda.sid.vo.model.PolicyActionBase_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyActionComposite_MVO extends PolicyActionBase_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PolicyActionComposite_MVO_id")
    @JsonManagedReference
    private List<PolicyActionRelationship_MVO> action;
    @JsonProperty("@type")
    private String type;
}
