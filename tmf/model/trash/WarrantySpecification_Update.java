package com.example.trash;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WarrantySpecification_Update implements java.io.Serializable {
    private Boolean isBundle;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @ManyToOne
    @JoinColumn(name = "targetEntitySchema_id")
    @JsonBackReference
    private TargetEntitySchema targetEntitySchema;
    @JsonProperty("@type")
    private String type;
    private String description;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Update_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> specCharacteristic;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Update_id")
    @JsonManagedReference
    private List<AgreementSpecification> warrantyAgreementSpecification;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Update_id")
    @JsonManagedReference
    private List<EntitySpecificationRelationship> entitySpecRelationship;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Update_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Update_id")
    @JsonManagedReference
    private List<WarrantySpecificationRelationship> warrantySpecRelationship;
    @ManyToOne
    @JoinColumn(name = "warrantyDuration_id")
    @JsonBackReference
    private Quantity warrantyDuration;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Update_id")
    @JsonManagedReference
    private List<WarrantySpecification> warrantySpecification;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Update_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Update_id")
    @JsonManagedReference
    private List<ConstraintRef> constraint;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Update_id")
    @JsonManagedReference
    private List<ProductSpecificationRef> productSpec;
    @OneToMany
    @JoinColumn(name = "WarrantySpecification_Update_id")
    @JsonManagedReference
    private List<ResourceSpecificationRef> resourceSpec;
}
