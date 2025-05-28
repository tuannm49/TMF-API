package oda.sid.vo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.util.logging.Logger;
import oda.sid.tmf.model.others.*;
import oda.sid.tmf.model.common.*;
import oda.sid.tmf.model.customer.*;
import oda.sid.tmf.model.party.*;
import oda.sid.tmf.model.product.*;
import oda.sid.tmf.model.resource.*;
import oda.sid.tmf.model.sale.*;
import oda.sid.tmf.model.service.*;
import oda.sid.tmf.model.base.*;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyRule_Update extends AbstractEntity implements java.io.Serializable {
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
