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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyCondition_Update implements java.io.Serializable {
    private OffsetDateTime creationDate;
    private String description;
    private Boolean isConjustiveNormalForm;
    private String name;
    private String policyConditionStrategy;
    private String version;
    @OneToMany
    @JoinColumn(name = "PolicyCondition_Update_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "PolicyCondition_Update_id")
    @JsonManagedReference
    private List<PolicyCondition> policyCondition;
    @OneToMany
    @JoinColumn(name = "PolicyCondition_Update_id")
    @JsonManagedReference
    private List<PolicyConditionStatement> policyConditionStatement;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
