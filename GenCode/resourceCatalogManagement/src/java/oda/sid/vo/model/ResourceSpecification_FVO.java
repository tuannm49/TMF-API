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
public class ResourceSpecification_FVO extends Entity_FVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private Boolean isBundle;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private IntentSpecificationRef_FVO intentSpecification;
    private String lifecycleStatus;
    @Embedded
    private TimePeriod validFor;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_FVO_RelatedPartyRefOrPartyRoleRef_FVO")
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_FVO_CharacteristicSpecification_FVO")
    private List<CharacteristicSpecification_FVO> resourceSpecCharacteristic;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_FVO_FeatureSpecification_FVO")
    private List<FeatureSpecification_FVO> featureSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_FVO_ResourceSpecificationRelationship_FVO")
    private List<ResourceSpecificationRelationship_FVO> resourceSpecRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_FVO_AttachmentRefOrValue_FVO")
    private List<EntityRef> attachment;
    private Date lastUpdate;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private TargetResourceSchema_FVO targetResourceSchema;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_FVO_ExternalIdentifier_FVO")
    private List<ExternalIdentifier_FVO> externalIdentifier;
    private String category;
}
