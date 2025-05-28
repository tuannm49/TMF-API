package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import oda.sid.tmf.model.base.AbstractEntity;
import oda.sid.tmf.model.base.TimePeriod;
import oda.sid.tmf.model.common.Note;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyCondition extends AbstractEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Note")
    private List<Note> note;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "PolicyConditionStatement")
    private List<PolicyConditionStatement> policyConditionStatement;
    @Embedded
    private TimePeriod validFor;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "PolicyCondition")
    private List<PolicyCondition> policyCondition;
    private Boolean isConjustiveNormalForm;
    private String description;
    private Date creationDate;
    private String policyConditionStrategy;
    private String version;
}
