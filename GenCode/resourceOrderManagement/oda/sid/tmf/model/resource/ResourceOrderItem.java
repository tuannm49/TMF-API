package oda.sid.tmf.model.resource;

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
public class ResourceOrderItem implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private OrderItemActionType action;
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonBackReference
    private AppointmentRef appointment;
    @OneToMany
    @JoinColumn(name = "ResourceOrderItem_id")
    @JsonManagedReference
    private List<ResourceOrderItemRelationship> orderItemRelationship;
    @ManyToOne
    @JoinColumn(name = "resource_id")
    @JsonBackReference
    private ResourceRefOrValue resource;
    @ManyToOne
    @JoinColumn(name = "resourceSpecification_id")
    @JsonBackReference
    private ResourceSpecificationRef resourceSpecification;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ResourceOrderItemStateType state;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
