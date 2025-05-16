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
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Warranty_Create implements java.io.Serializable {
    private String context;
    private String description;
    private String endDate;
    private Boolean isBundle;
    private Boolean isExternal;
    private String name;
    private String startDate;
    private String status;
    private String statusChangeDate;
    private String version;
    @OneToMany
    @JoinColumn(name = "Warranty_Create_id")
    @JsonManagedReference
    private List<ProductRefOrValue> appliesToProduct;
    @OneToMany
    @JoinColumn(name = "Warranty_Create_id")
    @JsonManagedReference
    private List<ResourceRefOrValue> appliesToResource;
    @OneToMany
    @JoinColumn(name = "Warranty_Create_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @OneToMany
    @JoinColumn(name = "Warranty_Create_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @OneToMany
    @JoinColumn(name = "Warranty_Create_id")
    @JsonManagedReference
    private List<EntityRelationship> entityRelationship;
    @ManyToOne
    @JoinColumn(name = "entitySpecification_id")
    @JsonBackReference
    private EntitySpecificationRef entitySpecification;
    @OneToMany
    @JoinColumn(name = "Warranty_Create_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "Warranty_Create_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue> place;
    @OneToMany
    @JoinColumn(name = "Warranty_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private WarrantyStateType state;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "Warranty_Create_id")
    @JsonManagedReference
    private List<Warranty> warranty;
    @OneToMany
    @JoinColumn(name = "Warranty_Create_id")
    @JsonManagedReference
    private List<AgreementRef> warrantyAgreement;
    @OneToMany
    @JoinColumn(name = "Warranty_Create_id")
    @JsonManagedReference
    private List<WarrantyRelationship> warrantyRelationship;
    @ManyToOne
    @JoinColumn(name = "warrantySpecification_id")
    @JsonBackReference
    private WarrantySpecificationRef warrantySpecification;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
