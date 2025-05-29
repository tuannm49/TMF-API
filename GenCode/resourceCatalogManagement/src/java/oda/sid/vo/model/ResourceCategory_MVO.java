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
public class ResourceCategory_MVO extends Entity_MVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private String lifecycleStatus;
    private Boolean isRoot;
    @Embedded
    private TimePeriod validFor;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceCategory_MVO_ResourceSpecificationRef_MVO")
    private List<ResourceSpecificationRef_MVO> resourceSpecification;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceCategory_MVO_RelatedPartyRefOrPartyRoleRef_MVO")
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceCategory_MVO_ResourceCandidateRef_MVO")
    private List<ResourceCandidateRef_MVO> resourceCandidate;
    private String parentId;
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceCategory_MVO_ExternalIdentifier_MVO")
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceCategory_MVO_ResourceCategoryRef_MVO")
    private List<ResourceCategoryRef_MVO> category;
}
