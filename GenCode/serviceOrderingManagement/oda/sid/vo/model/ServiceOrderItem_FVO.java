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
public class ServiceOrderItem_FVO implements java.io.Serializable {
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ServiceOrderItemStateType state;
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonBackReference
    private AppointmentRef appointment;
    @OneToMany
    @JoinColumn(name = "ServiceOrderItem_FVO_id")
    @JsonManagedReference
    private List<ServiceOrderItemRelationship> serviceOrderItemRelationship;
    @OneToMany
    @JoinColumn(name = "ServiceOrderItem_FVO_id")
    @JsonManagedReference
    private List<ServiceOrderItemErrorMessage> errorMessage;
    @OneToMany
    @JoinColumn(name = "ServiceOrderItem_FVO_id")
    @JsonManagedReference
    private List<ServiceOrderItem_FVO> serviceOrderItem;
    @ManyToOne
    @JoinColumn(name = "service_id")
    @JsonBackReference
    private ServiceRefOrValue_FVO service;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private OrderItemActionType action;
    @OneToMany
    @JoinColumn(name = "ServiceOrderItem_FVO_id")
    @JsonManagedReference
    private List<JsonPatch_FVO> modifyPath;
}
