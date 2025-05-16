package oda.sid.vo.mode;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.vo.mode.BaseEntity;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyCondition_Create extends BaseEntity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PolicyCondition_Create_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "PolicyCondition_Create_id")
    @JsonManagedReference
    private List<PolicyConditionStatement> policyConditionStatement;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "PolicyCondition_Create_id")
    @JsonManagedReference
    private List<PolicyCondition> policyCondition;
    private Boolean isConjustiveNormalForm;
    private String name;
    private String description;
    private OffsetDateTime creationDate;
    private String policyConditionStrategy;
    private String version;
}
