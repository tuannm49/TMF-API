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
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyRule implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private OffsetDateTime creationDate;
    private String description;
    private String executionStrategy;
    private Boolean isConjustiveNormalForm;
    private String name;
    private Integer sequencedAction;
    private Integer sequencedValue;
    private String state;
    private String version;
    @OneToMany
    @JoinColumn(name = "PolicyRule_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "PolicyRule_id")
    @JsonManagedReference
    private List<PolicyActionRef> policyAction;
    @ManyToOne
    @JoinColumn(name = "policyCondition_id")
    @JsonBackReference
    private PolicyConditionRef policyCondition;
    @OneToMany
    @JoinColumn(name = "PolicyRule_id")
    @JsonManagedReference
    private List<PolicyDomainRef> policyDomain;
    @ManyToOne
    @JoinColumn(name = "policyEvent_id")
    @JsonBackReference
    private PolicyEventRef policyEvent;
    @OneToMany
    @JoinColumn(name = "PolicyRule_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
