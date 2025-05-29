package oda.sid.tmf.entity.resource;

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
public class ResourceCategory extends AbstractEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private String lifecycleStatus;
    private Boolean isRoot;
    @Embedded
    private TimePeriod validFor;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceCategory_ResourceSpecificationRef")
    private List<EntityRef> resourceSpecification;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceCategory_RelatedPartyRefOrPartyRoleRef")
    private List<EntityRef> relatedParty;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceCategory_ResourceCandidateRef")
    private List<EntityRef> resourceCandidate;
    private String parentId;
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceCategory_ExternalIdentifier")
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceCategory_ResourceCategoryRef")
    private List<EntityRef> category;
}
