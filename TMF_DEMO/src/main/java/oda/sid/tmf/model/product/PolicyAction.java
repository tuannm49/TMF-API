package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import oda.sid.tmf.model.base.AbstractEntity;
import oda.sid.tmf.model.base.EntityRef;
import oda.sid.tmf.model.base.TimePeriod;
import oda.sid.tmf.model.common.Note;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyAction extends AbstractEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Note")
    private List<Note> note;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "PolicyAction")
    private List<PolicyAction> policyAction;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "actionCondition_PolicyConditionRef")
    private List<EntityRef> actionCondition;
    private String actionStrategy;
    @Embedded
    private TimePeriod validFor;
    private String description;
    private Integer actionSequence;
    private Date creationDate;
    private String version;
}
