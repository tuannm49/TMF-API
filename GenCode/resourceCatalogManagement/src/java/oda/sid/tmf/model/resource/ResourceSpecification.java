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
@IdClass(CatalogEntityId.class)
public class ResourceSpecification extends AbstractCatalogEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private Boolean isBundle;
    @OneToOne
    private EntityRef intentSpecification;
    private String lifecycleStatus;
    @Embedded
    private TimePeriod validFor;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_RelatedPartyRefOrPartyRoleRef")
    private List<EntityRef> relatedParty;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_CharacteristicSpecification")
    private List<CharacteristicSpecification> resourceSpecCharacteristic;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_FeatureSpecification")
    private List<FeatureSpecification> featureSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_ResourceSpecificationRelationship")
    private List<ResourceSpecificationRelationship> resourceSpecRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_AttachmentRefOrValue")
    private List<EntityRef> attachment;
    private Date lastUpdate;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private TargetResourceSchema targetResourceSchema;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ResourceSpecification_ExternalIdentifier")
    private List<ExternalIdentifier> externalIdentifier;
    private String category;
}
