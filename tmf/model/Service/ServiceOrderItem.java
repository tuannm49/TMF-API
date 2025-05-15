package com.example.Service;

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
public class ServiceOrderItem implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ServiceOrderItem_id")
    @JsonManagedReference
    private List<ServiceOrderItemRelationship> serviceOrderItemRelationship;
    @OneToMany
    @JoinColumn(name = "ServiceOrderItem_id")
    @JsonManagedReference
    private List<ServiceOrderItem> serviceOrderItem;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "service_id")
    @JsonBackReference
    private ServiceRefOrValue service;
    @OneToMany
    @JoinColumn(name = "ServiceOrderItem_id")
    @JsonManagedReference
    private List<ServiceOrderItemErrorMessage> errorMessage;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private OrderItemActionType action;
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonBackReference
    private AppointmentRef appointment;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ServiceOrderItemStateType state;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "ServiceOrderItem_id")
    @JsonManagedReference
    private List<JsonPatch> modifyPath;
}
