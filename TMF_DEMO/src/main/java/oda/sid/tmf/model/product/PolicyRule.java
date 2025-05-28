package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import oda.sid.tmf.model.base.AbstractEntity;
import oda.sid.tmf.model.base.EntityRef;
import oda.sid.tmf.model.base.RelatedParty;
import oda.sid.tmf.model.common.Note;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyRule extends AbstractEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Note")
    private List<Note> note;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "policyAction_PolicyActionRef")
    private List<EntityRef> policyAction;
    @OneToOne
    private EntityRef policyCondition;
    private Boolean isConjustiveNormalForm;
    private String description;
    private Integer sequencedAction;
    private Date creationDate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "RelatedParty")
    private List<RelatedParty> relatedParty;
    private String version;
    @OneToOne
    private EntityRef policyEvent;
    private Integer sequencedValue;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "policyDomain_PolicyDomainRef")
    private List<EntityRef> policyDomain;
    private String executionStrategy;
    private String state;
}
