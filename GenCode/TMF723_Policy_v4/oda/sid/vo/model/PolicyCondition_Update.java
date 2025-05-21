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
import oda.sid.tmf.model.base.*;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyCondition_Update extends BaseEntity implements java.io.Serializable {
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PolicyCondition_Update_id")
    private List<Note> note;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PolicyCondition_Update_id")
    private List<PolicyConditionStatement> policyConditionStatement;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="type", column=@Column(name = "target_type")),@AttributeOverride(name="schemaLocation", column=@Column(name = "target_schemaLocation"))})
    private TimePeriod validFor;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PolicyCondition_Update_id")
    private List<PolicyCondition> policyCondition;
    private Boolean isConjustiveNormalForm;
    private Date creationDate;
    private String policyConditionStrategy;
}
