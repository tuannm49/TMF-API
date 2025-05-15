package com.example.trash;

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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DunningCase_Create implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "DunningCase_Create_id")
    @JsonManagedReference
    private List<Characteristic> note;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private OffsetDateTime lastUpdateDate;
    @JsonProperty("@type")
    private String type;
    private String description;
    @OneToMany
    @JoinColumn(name = "DunningCase_Create_id")
    @JsonManagedReference
    private List<DunningCaseRule> dunningCaseRule;
    private OffsetDateTime creationDate;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef billingAccount;
    @OneToMany
    @JoinColumn(name = "DunningCase_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime lastActivityDate;
    @ManyToOne
    @JoinColumn(name = "finalBalance_id")
    @JsonBackReference
    private AccountBalance finalBalance;
    @ManyToOne
    @JoinColumn(name = "initialBalance_id")
    @JsonBackReference
    private AccountBalance initialBalance;
    @ManyToOne
    @JoinColumn(name = "dunningScenario_id")
    @JsonBackReference
    private DunningScenarioRef dunningScenario;
    private String category;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String status;
}
