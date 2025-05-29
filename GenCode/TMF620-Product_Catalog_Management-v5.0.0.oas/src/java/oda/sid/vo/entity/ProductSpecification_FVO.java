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
public class ProductSpecification_FVO extends Entity_FVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private Boolean isBundle;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_FVO_CharacteristicSpecification_FVO")
    private List<CharacteristicSpecification_FVO> productSpecCharacteristic;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private IntentSpecificationRef_FVO intentSpecification;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private TargetProductSchema_FVO targetProductSchema;
    private String lifecycleStatus;
    @Embedded
    private TimePeriod validFor;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_FVO_ServiceSpecificationRef_FVO")
    private List<ServiceSpecificationRef_FVO> serviceSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_FVO_ResourceSpecificationRef_FVO")
    private List<ResourceSpecificationRef_FVO> resourceSpecification;
    private String description;
    private String productNumber;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_FVO_RelatedPartyRefOrPartyRoleRef_FVO")
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_FVO_AttachmentRefOrValue_FVO")
    private List<EntityRef> attachment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_FVO_BundledProductSpecification_FVO")
    private List<BundledProductSpecification_FVO> bundledProductSpecification;
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_FVO_ProductSpecificationRelationship_FVO")
    private List<ProductSpecificationRelationship_FVO> productSpecificationRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_FVO_ExternalIdentifier_FVO")
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_FVO_CategoryRef_FVO")
    private List<CategoryRef_FVO> category;
    private String brand;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_FVO_PolicyRef_FVO")
    private List<PolicyRef_FVO> policy;
}
