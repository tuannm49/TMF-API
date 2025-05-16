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
public class ShipmentSpecification_Update implements java.io.Serializable {
    private String description;
    private Boolean isBundle;
    private String lifecycleStatus;
    private String name;
    private String version;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecification_Update_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecification_Update_id")
    @JsonManagedReference
    private List<ConstraintRef> constraint;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecification_Update_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecification_Update_id")
    @JsonManagedReference
    private List<ShipmentSpecificationRelationship> shipmentSpecRelationship;
    @ManyToOne
    @JoinColumn(name = "signatureRequiredBy_id")
    @JsonBackReference
    private SignatureRequiredByType signatureRequiredBy;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecification_Update_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> specCharacteristic;
    @ManyToOne
    @JoinColumn(name = "targetShipmentSchema_id")
    @JsonBackReference
    private TargetShipmentSchema targetShipmentSchema;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
