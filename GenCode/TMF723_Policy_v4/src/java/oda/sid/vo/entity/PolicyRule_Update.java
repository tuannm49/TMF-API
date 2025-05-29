package oda.sid.vo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.util.logging.Logger;
import oda.sid.tmf.entity.others.*;
import oda.sid.tmf.entity.common.*;
import oda.sid.tmf.entity.customer.*;
import oda.sid.tmf.entity.party.*;
import oda.sid.tmf.entity.product.*;
import oda.sid.tmf.entity.resource.*;
import oda.sid.tmf.entity.sale.*;
import oda.sid.tmf.entity.service.*;
import oda.sid.tmf.entity.base.*;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyRule_Update extends AbstractEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "PolicyRule_Update_Note")
    private List<Note> note;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "PolicyRule_Update_PolicyActionRef")
    private List<EntityRef> policyAction;
    @OneToOne
    private EntityRef policyCondition;
    private Boolean isConjustiveNormalForm;
    private String description;
    private Integer sequencedAction;
    private Date creationDate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "PolicyRule_Update_RelatedParty")
    private List<RelatedParty> relatedParty;
    private String version;
    @OneToOne
    private EntityRef policyEvent;
    private Integer sequencedValue;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "PolicyRule_Update_PolicyDomainRef")
    private List<EntityRef> policyDomain;
    private String executionStrategy;
    private String state;
}
