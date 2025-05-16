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
import oda.sid.vo.model.Entity_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClosedLoop_FVO extends Entity_FVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private OffsetDateTime plannedEnd;
    @ManyToOne
    @JoinColumn(name = "closedLoopGoal_id")
    @JsonBackReference
    private ClosedLoopGoalRef_FVO closedLoopGoal;
    @ManyToOne
    @JoinColumn(name = "closedLoopSpecification_id")
    @JsonBackReference
    private EntitySpecificationRef_FVO closedLoopSpecification;
    @ManyToOne
    @JoinColumn(name = "egressPoint_id")
    @JsonBackReference
    private EntityRef_FVO egressPoint;
    private String description;
    private OffsetDateTime creationDate;
    private OffsetDateTime plannedStart;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private PartyOrPartyRole_FVO relatedParty;
    @OneToMany
    @JoinColumn(name = "ClosedLoop_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> characteristic;
    @OneToMany
    @JoinColumn(name = "ClosedLoop_FVO_id")
    @JsonManagedReference
    private List<EntityRelationship_FVO> closedLoopRelationship;
    private String name;
    @ManyToOne
    @JoinColumn(name = "ingressPoint_id")
    @JsonBackReference
    private EntityRef_FVO ingressPoint;
    @ManyToOne
    @JoinColumn(name = "policy_id")
    @JsonBackReference
    private PolicyRef_FVO policy;
}
