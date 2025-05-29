package oda.sid.tmf.model.product;

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
public class PolicyAction extends AbstractEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "PolicyAction_Note")
    private List<Note> note;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "PolicyAction_PolicyAction")
    private List<PolicyAction> policyAction;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "PolicyAction_PolicyConditionRef")
    private List<EntityRef> actionCondition;
    private String actionStrategy;
    @Embedded
    private TimePeriod validFor;
    private String description;
    private Integer actionSequence;
    private Date creationDate;
    private String version;
}
