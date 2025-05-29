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
public class ResourceSpecification_MVO extends Entity_MVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private Boolean isBundle;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private IntentSpecificationRef_MVO intentSpecification;
    private String lifecycleStatus;
    @Embedded
    private TimePeriod validFor;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_MVO_RelatedPartyRefOrPartyRoleRef_MVO")
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_MVO_CharacteristicSpecification_MVO")
    private List<CharacteristicSpecification_MVO> resourceSpecCharacteristic;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_MVO_FeatureSpecification_MVO")
    private List<FeatureSpecification_MVO> featureSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_MVO_ResourceSpecificationRelationship_MVO")
    private List<ResourceSpecificationRelationship_MVO> resourceSpecRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_MVO_AttachmentRefOrValue_MVO")
    private List<EntityRef> attachment;
    private Date lastUpdate;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private TargetResourceSchema_MVO targetResourceSchema;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_MVO_ExternalIdentifier_MVO")
    private List<ExternalIdentifier_MVO> externalIdentifier;
    private String category;
}
