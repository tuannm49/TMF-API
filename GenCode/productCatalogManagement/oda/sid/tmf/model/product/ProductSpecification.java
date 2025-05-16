package oda.sid.tmf.model.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.tmf.model.product.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductSpecification extends Entity implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> productSpecCharacteristic;
    @ManyToOne
    @JoinColumn(name = "intentSpecification_id")
    @JsonBackReference
    private IntentSpecificationRef intentSpecification;
    @ManyToOne
    @JoinColumn(name = "targetProductSchema_id")
    @JsonBackReference
    private TargetProductSchema targetProductSchema;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_id")
    @JsonManagedReference
    private List<ServiceSpecificationRef> serviceSpecification;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_id")
    @JsonManagedReference
    private List<ResourceSpecificationRef> resourceSpecification;
    private String description;
    private String productNumber;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_id")
    @JsonManagedReference
    private List<BundledProductSpecification> bundledProductSpecification;
    private OffsetDateTime lastUpdate;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_id")
    @JsonManagedReference
    private List<ProductSpecificationRelationship> productSpecificationRelationship;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_id")
    @JsonManagedReference
    private List<CategoryRef> category;
    private String brand;
    @OneToMany
    @JoinColumn(name = "ProductSpecification_id")
    @JsonManagedReference
    private List<PolicyRef> policy;
}
