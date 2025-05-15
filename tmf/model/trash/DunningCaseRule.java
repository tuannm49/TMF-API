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
public class DunningCaseRule implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "DunningCaseRule_id")
    @JsonManagedReference
    private List<PartyInteractionRef> dunningNotification;
    @ManyToOne
    @JoinColumn(name = "customerBill_id")
    @JsonBackReference
    private CustomerBillRef customerBill;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "dunningWriteOff_id")
    @JsonBackReference
    private DunningWriteOff dunningWriteOff;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "appliedPenaltyCharge_id")
    @JsonBackReference
    private AppliedCustomerBillingRate appliedPenaltyCharge;
    @ManyToOne
    @JoinColumn(name = "dunningRule_id")
    @JsonBackReference
    private DunningRuleRef dunningRule;
    private String action;
    @ManyToOne
    @JoinColumn(name = "productOrder_id")
    @JsonBackReference
    private ProductOrderRef productOrder;
    @Id
    private String id;
    private OffsetDateTime creationDate;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
