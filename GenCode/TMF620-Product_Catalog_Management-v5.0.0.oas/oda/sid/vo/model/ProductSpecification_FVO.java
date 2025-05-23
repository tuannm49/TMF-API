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
public class ProductSpecification_FVO extends Entity_FVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    private Boolean isBundle;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdSpec_FVO_productSpecChar")
    private List<CharacteristicSpecification_FVO> productSpecCharacteristic;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private IntentSpecificationRef_FVO intentSpecification;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private TargetProductSchema_FVO targetProductSchema;
    private String lifecycleStatus;
    @Embedded
    private TimePeriod validFor;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdSpec_FVO_serviceSpec")
    private List<ServiceSpecificationRef_FVO> serviceSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdSpec_FVO_resourceSpec")
    private List<ResourceSpecificationRef_FVO> resourceSpecification;
    private String description;
    private String productNumber;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdSpec_FVO_relatedPty")
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdSpec_FVO_attachment")
    private List<AttachmentRefOrValue_FVO> attachment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdSpec_FVO_bundledProdSpec")
    private List<BundledProductSpecification_FVO> bundledProductSpecification;
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdSpec_FVO_productSpecRel")
    private List<ProductSpecificationRelationship_FVO> productSpecificationRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdSpec_FVO")
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdSpec_FVO_category")
    private List<CategoryRef_FVO> category;
    private String brand;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdSpec_FVO_policy")
    private List<PolicyRef_FVO> policy;
}
