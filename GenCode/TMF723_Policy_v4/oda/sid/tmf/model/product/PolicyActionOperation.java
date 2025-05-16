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
public class PolicyActionOperation implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private Integer actionSequence;
    private String actionStrategy;
    private OffsetDateTime creationDate;
    private String description;
    private String fields;
    private String filter;
    private String name;
    private String operation;
    private String path;
    private String version;
    @OneToMany
    @JoinColumn(name = "PolicyActionOperation_id")
    @JsonManagedReference
    private List<PolicyConditionRef> actionCondition;
    @ManyToOne
    @JoinColumn(name = "actionValue_id")
    @JsonBackReference
    private PolicyActionValue actionValue;
    @OneToMany
    @JoinColumn(name = "PolicyActionOperation_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "PolicyActionOperation_id")
    @JsonManagedReference
    private List<PolicyAction> policyAction;
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
