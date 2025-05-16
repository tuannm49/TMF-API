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
public class ShipmentSpecificationRefOrValue_FVO implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecificationRefOrValue_FVO_id")
    @JsonManagedReference
    private List<ShipmentSpecificationRelationship_FVO> shipmentSpecRelationship;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String description;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecificationRefOrValue_FVO_id")
    @JsonManagedReference
    private List<RelatedParty_FVO> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecificationRefOrValue_FVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_FVO> shipmentSpecificationCharacteristic;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecificationRefOrValue_FVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_FVO> attachment;
    @ManyToOne
    @JoinColumn(name = "targetShipmentSchema_id")
    @JsonBackReference
    private TargetShipmentSchema_FVO targetShipmentSchema;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "ShipmentSpecificationRefOrValue_FVO_id")
    @JsonManagedReference
    private List<ConstraintRef_FVO> constraint;
}
