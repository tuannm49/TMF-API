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
public class ProductSpecification_MVO extends Entity_MVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private Boolean isBundle;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_MVO_CharacteristicSpecification_MVO")
    private List<CharacteristicSpecification_MVO> productSpecCharacteristic;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private IntentSpecificationRef_MVO intentSpecification;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private TargetProductSchema_MVO targetProductSchema;
    private String lifecycleStatus;
    @Embedded
    private TimePeriod validFor;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_MVO_ServiceSpecificationRef_MVO")
    private List<ServiceSpecificationRef_MVO> serviceSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_MVO_ResourceSpecificationRef_MVO")
    private List<ResourceSpecificationRef_MVO> resourceSpecification;
    private String description;
    private String productNumber;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_MVO_RelatedPartyRefOrPartyRoleRef_MVO")
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_MVO_AttachmentRefOrValue_MVO")
    private List<EntityRef> attachment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_MVO_BundledProductSpecification_MVO")
    private List<BundledProductSpecification_MVO> bundledProductSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_MVO_ProductSpecificationRelationship_MVO")
    private List<ProductSpecificationRelationship_MVO> productSpecificationRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_MVO_ExternalIdentifier_MVO")
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_MVO_CategoryRef_MVO")
    private List<CategoryRef_MVO> category;
    private String brand;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecification_MVO_PolicyRef_MVO")
    private List<PolicyRef_MVO> policy;
}
