package oda.sid.vo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import java.util.List;
import java.util.Date;
import oda.sid.tmf.model.others.*;
import oda.sid.tmf.model.common.*;
import oda.sid.tmf.model.customer.*;
import oda.sid.tmf.model.party.*;
import oda.sid.tmf.model.product.*;
import oda.sid.tmf.model.resource.*;
import oda.sid.tmf.model.sale.*;
import oda.sid.tmf.model.service.*;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyRule_Update extends BaseEntity implements java.io.Serializable {
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PolicyRule_Update_id")
    private List<Note> note;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PolicyRule_Update_id")
    private List<PolicyActionRef> policyAction;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "policyCondition_id")
    private PolicyConditionRef policyCondition;
    private Boolean isConjustiveNormalForm;
    private String description;
    private Integer sequencedAction;
    private Date creationDate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PolicyRule_Update_id")
    private List<RelatedParty> relatedParty;
    private String version;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "policyEvent_id")
    private PolicyEventRef policyEvent;
    private Integer sequencedValue;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PolicyRule_Update_id")
    private List<PolicyDomainRef> policyDomain;
    private String executionStrategy;
    private String state;
}
