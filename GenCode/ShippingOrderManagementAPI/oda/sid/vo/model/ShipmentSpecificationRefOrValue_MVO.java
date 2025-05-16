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
public class ShipmentSpecificationRefOrValue_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecificationRefOrValue_MVO_id")
    @JsonManagedReference
    private List<ShipmentSpecificationRelationship_MVO> shipmentSpecRelationship;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String description;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecificationRefOrValue_MVO_id")
    @JsonManagedReference
    private List<RelatedParty_MVO> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecificationRefOrValue_MVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_MVO> shipmentSpecificationCharacteristic;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecificationRefOrValue_MVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_MVO> attachment;
    @ManyToOne
    @JoinColumn(name = "targetShipmentSchema_id")
    @JsonBackReference
    private TargetShipmentSchema_MVO targetShipmentSchema;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecificationRefOrValue_MVO_id")
    @JsonManagedReference
    private List<ConstraintRef_MVO> constraint;
}
