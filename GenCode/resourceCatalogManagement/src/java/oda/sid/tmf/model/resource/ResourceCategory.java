package oda.sid.tmf.model.resource;

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
