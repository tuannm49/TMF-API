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
public class EntitySpecification_MVO extends Entity_MVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private Boolean isBundle;
    private String lifecycleStatus;
    @Embedded
    private TimePeriod validFor;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private TargetEntitySchema_MVO targetEntitySchema;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "EntitySpecification_MVO_CharacteristicSpecification_MVO")
    private List<CharacteristicSpecification_MVO> specCharacteristic;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "EntitySpecification_MVO_EntitySpecificationRelationship_MVO")
    private List<EntitySpecificationRelationship_MVO> entitySpecRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "EntitySpecification_MVO_RelatedPartyRefOrPartyRoleRef_MVO")
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "EntitySpecification_MVO_AttachmentRefOrValue_MVO")
    private List<EntityRef> attachment;
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "EntitySpecification_MVO_ConstraintRef_MVO")
    private List<ConstraintRef_MVO> constraint;
}
