package oda.sid.tmf.model.others;

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
public class DunningCase implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private String category;
    private OffsetDateTime creationDate;
    private String description;
    private OffsetDateTime lastActivityDate;
    private OffsetDateTime lastUpdateDate;
    private String status;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef billingAccount;
    @OneToMany
    @JoinColumn(name = "DunningCase_id")
    @JsonManagedReference
    private List<DunningCaseRule> dunningCaseRule;
    @ManyToOne
    @JoinColumn(name = "dunningScenario_id")
    @JsonBackReference
    private DunningScenarioRef dunningScenario;
    @ManyToOne
    @JoinColumn(name = "finalBalance_id")
    @JsonBackReference
    private AccountBalance finalBalance;
    @ManyToOne
    @JoinColumn(name = "initialBalance_id")
    @JsonBackReference
    private AccountBalance initialBalance;
    @OneToMany
    @JoinColumn(name = "DunningCase_id")
    @JsonManagedReference
    private List<Characteristic> note;
    @OneToMany
    @JoinColumn(name = "DunningCase_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
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
