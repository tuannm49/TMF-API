package oda.sid.vo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import java.util.List;
import java.util.Date;
import oda.sid.tmf.model.others.*;
import oda.sid.tmf.model.common.*;
import oda.sid.tmf.model.customer.*;
import oda.sid.tmf.model.party.*;
import oda.sid.tmf.model.product.*;
import oda.sid.tmf.model.resource.*;
import oda.sid.tmf.model.sale.*;
import oda.sid.tmf.model.service.*;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductSpecification_MVO extends Entity_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductSpecification_MVO_id")
    private List<CharacteristicSpecification_MVO> productSpecCharacteristic;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "intentSpecification_id")
    private IntentSpecificationRef_MVO intentSpecification;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "targetProductSchema_id")
    private TargetProductSchema_MVO targetProductSchema;
    private String lifecycleStatus;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="type", column=@Column(name = "target_type")),@AttributeOverride(name="schemaLocation", column=@Column(name = "target_schemaLocation"))})
    private TimePeriod validFor;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductSpecification_MVO_id")
    private List<ServiceSpecificationRef_MVO> serviceSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductSpecification_MVO_id")
    private List<ResourceSpecificationRef_MVO> resourceSpecification;
    private String description;
    private String productNumber;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductSpecification_MVO_id")
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductSpecification_MVO_id")
    private List<AttachmentRefOrValue_MVO> attachment;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductSpecification_MVO_id")
    private List<BundledProductSpecification_MVO> bundledProductSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductSpecification_MVO_id")
    private List<ProductSpecificationRelationship_MVO> productSpecificationRelationship;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductSpecification_MVO_id")
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductSpecification_MVO_id")
    private List<CategoryRef_MVO> category;
    private String brand;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductSpecification_MVO_id")
    private List<PolicyRef_MVO> policy;
}
