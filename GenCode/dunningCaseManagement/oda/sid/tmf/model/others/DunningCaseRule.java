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
public class DunningCaseRule implements java.io.Serializable {
    @Id
    private String id;
    private String action;
    private OffsetDateTime creationDate;
    @ManyToOne
    @JoinColumn(name = "appliedPenaltyCharge_id")
    @JsonBackReference
    private AppliedCustomerBillingRate appliedPenaltyCharge;
    @ManyToOne
    @JoinColumn(name = "customerBill_id")
    @JsonBackReference
    private CustomerBillRef customerBill;
    @OneToMany
    @JoinColumn(name = "DunningCaseRule_id")
    @JsonManagedReference
    private List<PartyInteractionRef> dunningNotification;
    @ManyToOne
    @JoinColumn(name = "dunningRule_id")
    @JsonBackReference
    private DunningRuleRef dunningRule;
    @ManyToOne
    @JoinColumn(name = "dunningWriteOff_id")
    @JsonBackReference
    private DunningWriteOff dunningWriteOff;
    @ManyToOne
    @JoinColumn(name = "productOrder_id")
    @JsonBackReference
    private ProductOrderRef productOrder;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
