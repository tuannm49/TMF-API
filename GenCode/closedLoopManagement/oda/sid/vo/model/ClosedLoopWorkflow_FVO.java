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
import oda.sid.vo.model.Entity_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClosedLoopWorkflow_FVO extends Entity_FVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "closedLoopWorkflowActivity_id")
    @JsonBackReference
    private ClosedLoopWorkflowActivityRef_FVO closedLoopWorkflowActivity;
    private OffsetDateTime creationdate;
    @ManyToOne
    @JoinColumn(name = "closedLoop_id")
    @JsonBackReference
    private ClosedLoopRef_FVO closedLoop;
    private OffsetDateTime validfor;
    @ManyToOne
    @JoinColumn(name = "startedBy_id")
    @JsonBackReference
    private Trigger_FVO startedBy;
    @ManyToOne
    @JoinColumn(name = "egressPoint_id")
    @JsonBackReference
    private EntityRef_FVO egressPoint;
    private String name;
    @ManyToOne
    @JoinColumn(name = "ingressPoint_id")
    @JsonBackReference
    private EntityRef_FVO ingressPoint;
    @ManyToOne
    @JoinColumn(name = "closedLoopWorkflowPriority_id")
    @JsonBackReference
    private ClosedLoopWorkflowPriorityRef_FVO closedLoopWorkflowPriority;
    private String description;
    @ManyToOne
    @JoinColumn(name = "endedBy_id")
    @JsonBackReference
    private Trigger_FVO endedBy;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private PartyOrPartyRole_FVO relatedParty;
}
