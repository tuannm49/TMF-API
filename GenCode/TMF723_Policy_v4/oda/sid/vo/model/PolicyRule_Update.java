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
public class PolicyRule_Update extends BaseEntity implements java.io.Serializable {
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PolicyRule_Update_id")
    private List<Note> note;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_policyAction", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<PolicyActionRef> policyAction;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="id", column=@Column(name = "policyCondition_id")),
            @AttributeOverride(name="name", column=@Column(name = "policyCondition_name")),
            @AttributeOverride(name="version", column=@Column(name = "policyCondition_version")),
            @AttributeOverride(name="href", column=@Column(name = "policyCondition_href")),
            @AttributeOverride(name="type", column=@Column(name = "policyCondition_type")),
            @AttributeOverride(name="baseType", column=@Column(name = "policyCondition_baseType")),
            @AttributeOverride(name="referredType", column=@Column(name = "policyCondition_referredType")),
            @AttributeOverride(name="schemaLocation", column=@Column(name = "policyCondition_schemaLocation"))
    })
    private PolicyConditionRef policyCondition;
    private Boolean isConjustiveNormalForm;
    private Integer sequencedAction;
    private Date creationDate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PolicyRule_Update_id")
    private List<RelatedParty> relatedParty;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="id", column=@Column(name = "policyEvent_id")),
            @AttributeOverride(name="name", column=@Column(name = "policyEvent_name")),
            @AttributeOverride(name="version", column=@Column(name = "policyEvent_version")),
            @AttributeOverride(name="href", column=@Column(name = "policyEvent_href")),
            @AttributeOverride(name="type", column=@Column(name = "policyEvent_type")),
            @AttributeOverride(name="baseType", column=@Column(name = "policyEvent_baseType")),
            @AttributeOverride(name="referredType", column=@Column(name = "policyEvent_referredType")),
            @AttributeOverride(name="schemaLocation", column=@Column(name = "policyEvent_schemaLocation"))
    })
    private PolicyEventRef policyEvent;
    private Integer sequencedValue;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_policyDomain", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<PolicyDomainRef> policyDomain;
    private String executionStrategy;
    private String state;
}
