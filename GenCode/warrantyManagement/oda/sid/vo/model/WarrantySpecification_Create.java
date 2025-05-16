package oda.sid.vo.model;

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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WarrantySpecification_Create implements java.io.Serializable {
    private String description;
    private Boolean isBundle;
    private OffsetDateTime lastUpdate;
    private String lifecycleStatus;
    private String name;
    private String version;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Create_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Create_id")
    @JsonManagedReference
    private List<ConstraintRef> constraint;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Create_id")
    @JsonManagedReference
    private List<EntitySpecificationRelationship> entitySpecRelationship;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Create_id")
    @JsonManagedReference
    private List<ProductSpecificationRef> productSpec;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Create_id")
    @JsonManagedReference
    private List<ResourceSpecificationRef> resourceSpec;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Create_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> specCharacteristic;
    @ManyToOne
    @JoinColumn(name = "targetEntitySchema_id")
    @JsonBackReference
    private TargetEntitySchema targetEntitySchema;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Create_id")
    @JsonManagedReference
    private List<AgreementSpecification> warrantyAgreementSpecification;
    @ManyToOne
    @JoinColumn(name = "warrantyDuration_id")
    @JsonBackReference
    private Quantity warrantyDuration;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Create_id")
    @JsonManagedReference
    private List<WarrantySpecificationRelationship> warrantySpecRelationship;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Create_id")
    @JsonManagedReference
    private List<WarrantySpecification> warrantySpecification;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
