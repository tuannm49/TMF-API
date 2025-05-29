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
