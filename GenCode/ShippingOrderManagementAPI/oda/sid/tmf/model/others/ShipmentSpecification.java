package oda.sid.tmf.model.others;

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
import oda.sid.tmf.model.others.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShipmentSpecification extends Entity implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecification_id")
    @JsonManagedReference
    private List<ShipmentSpecificationRelationship> shipmentSpecRelationship;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String description;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecification_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecification_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> shipmentSpecificationCharacteristic;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecification_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @ManyToOne
    @JoinColumn(name = "targetShipmentSchema_id")
    @JsonBackReference
    private TargetShipmentSchema targetShipmentSchema;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecification_id")
    @JsonManagedReference
    private List<ConstraintRef> constraint;
}
