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
public class Intent_FVO extends Entity_FVO implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "intentSpecification_id")
    @JsonBackReference
    private EntityRef_FVO intentSpecification;
    @OneToMany
    @JoinColumn(name = "Intent_FVO_id")
    @JsonManagedReference
    private List<EntityRelationship> intentRelationship;
    @ManyToOne
    @JoinColumn(name = "expression_id")
    @JsonBackReference
    private IntentExpression_FVO expression;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String description;
    private String priority;
    @OneToMany
    @JoinColumn(name = "Intent_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    private OffsetDateTime creationDate;
    private String version;
    @OneToMany
    @JoinColumn(name = "Intent_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> characteristic;
    private OffsetDateTime statusChangeDate;
    @OneToMany
    @JoinColumn(name = "Intent_FVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    private OffsetDateTime lastUpdate;
    private String context;
    private String name;
}
