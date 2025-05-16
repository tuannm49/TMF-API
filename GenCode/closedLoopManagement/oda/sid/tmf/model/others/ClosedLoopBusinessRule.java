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
import oda.sid.tmf.model.others.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClosedLoopBusinessRule extends Entity implements java.io.Serializable {
    private OffsetDateTime creationdate;
    private String whyInvoke;
    private OffsetDateTime validfor;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "closedLoopBusinessRuleSpecification_id")
    @JsonBackReference
    private EntitySpecificationRef closedLoopBusinessRuleSpecification;
    @ManyToOne
    @JoinColumn(name = "businessRuleTriggerEvent_id")
    @JsonBackReference
    private EventRef businessRuleTriggerEvent;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private PartyOrPartyRole relatedParty;
    private String value;
}
