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
public class ServiceOrderItem_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ServiceOrderItem_MVO_id")
    @JsonManagedReference
    private List<ServiceOrderItemRelationship_MVO> serviceOrderItemRelationship;
    @OneToMany
    @JoinColumn(name = "ServiceOrderItem_MVO_id")
    @JsonManagedReference
    private List<ServiceOrderItem_MVO> serviceOrderItem;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "service_id")
    @JsonBackReference
    private ServiceRefOrValue_MVO service;
    @OneToMany
    @JoinColumn(name = "ServiceOrderItem_MVO_id")
    @JsonManagedReference
    private List<ServiceOrderItemErrorMessage_MVO> errorMessage;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private OrderItemActionType action;
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonBackReference
    private AppointmentRef_MVO appointment;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ServiceOrderItemStateType_MVO state;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "ServiceOrderItem_MVO_id")
    @JsonManagedReference
    private List<JsonPatch_MVO> modifyPath;
}
