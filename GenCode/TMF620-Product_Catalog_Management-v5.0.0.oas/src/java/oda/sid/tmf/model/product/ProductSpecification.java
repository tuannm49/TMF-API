package oda.sid.tmf.model.product;

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
public class ProductSpecification extends AbstractCatalogEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private Boolean isBundle;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_CharacteristicSpecification")
    private List<CharacteristicSpecification> productSpecCharacteristic;
    @OneToOne
    private EntityRef intentSpecification;
    @OneToOne
    private EntityRef targetProductSchema;
    private String lifecycleStatus;
    @Embedded
    private TimePeriod validFor;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_ServiceSpecificationRef")
    private List<EntityRef> serviceSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_ResourceSpecificationRef")
    private List<EntityRef> resourceSpecification;
    private String description;
    private String productNumber;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_RelatedPartyRefOrPartyRoleRef")
    private List<EntityRef> relatedParty;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_AttachmentRefOrValue")
    private List<EntityRef> attachment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_BundledProductSpecification")
    private List<BundledProductSpecification> bundledProductSpecification;
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_ProductSpecificationRelationship")
    private List<ProductSpecificationRelationship> productSpecificationRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_ExternalIdentifier")
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_CategoryRef")
    private List<EntityRef> category;
    private String brand;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_PolicyRef")
    private List<EntityRef> policy;
}
