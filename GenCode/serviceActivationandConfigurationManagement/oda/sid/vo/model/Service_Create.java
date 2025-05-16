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
public class Service_Create implements java.io.Serializable {
    private String category;
    private String description;
    private OffsetDateTime endDate;
    private Boolean hasStarted;
    private Boolean isBundle;
    private Boolean isServiceEnabled;
    private Boolean isStateful;
    private String name;
    private String serviceDate;
    private String serviceType;
    private OffsetDateTime startDate;
    private String startMode;
    @OneToMany
    @JoinColumn(name = "Service_Create_id")
    @JsonManagedReference
    private List<Feature> feature;
    @OneToMany
    @JoinColumn(name = "Service_Create_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "Service_Create_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue> place;
    @OneToMany
    @JoinColumn(name = "Service_Create_id")
    @JsonManagedReference
    private List<RelatedEntityRefOrValue> relatedEntity;
    @OneToMany
    @JoinColumn(name = "Service_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @OneToMany
    @JoinColumn(name = "Service_Create_id")
    @JsonManagedReference
    private List<Characteristic> serviceCharacteristic;
    @OneToMany
    @JoinColumn(name = "Service_Create_id")
    @JsonManagedReference
    private List<RelatedServiceOrderItem> serviceOrderItem;
    @OneToMany
    @JoinColumn(name = "Service_Create_id")
    @JsonManagedReference
    private List<ServiceRelationship> serviceRelationship;
    @ManyToOne
    @JoinColumn(name = "serviceSpecification_id")
    @JsonBackReference
    private ServiceSpecificationRef serviceSpecification;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ServiceStateType state;
    @OneToMany
    @JoinColumn(name = "Service_Create_id")
    @JsonManagedReference
    private List<ResourceRef> supportingResource;
    @OneToMany
    @JoinColumn(name = "Service_Create_id")
    @JsonManagedReference
    private List<ServiceRefOrValue> supportingService;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
