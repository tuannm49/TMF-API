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
public class ResourceCategory_FVO extends Entity_FVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private String lifecycleStatus;
    private Boolean isRoot;
    @Embedded
    private TimePeriod validFor;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceCategory_FVO_ResourceSpecificationRef_FVO")
    private List<ResourceSpecificationRef_FVO> resourceSpecification;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceCategory_FVO_RelatedPartyRefOrPartyRoleRef_FVO")
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceCategory_FVO_ResourceCandidateRef_FVO")
    private List<ResourceCandidateRef_FVO> resourceCandidate;
    private String parentId;
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceCategory_FVO_ExternalIdentifier_FVO")
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceCategory_FVO_ResourceCategoryRef_FVO")
    private List<ResourceCategoryRef_FVO> category;
}
