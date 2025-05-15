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
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceOrder_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ServiceOrder_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    private String cancellationReason;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ServiceOrder_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> orderCharacteristic;
    private String description;
    @ManyToOne
    @JoinColumn(name = "orderSpecification_id")
    @JsonBackReference
    private OrderSpecificationRef_MVO orderSpecification;
    private String priority;
    @OneToMany
    @JoinColumn(name = "ServiceOrder_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private OffsetDateTime requestedStartDate;
    @OneToMany
    @JoinColumn(name = "ServiceOrder_MVO_id")
    @JsonManagedReference
    private List<ExternalReference_MVO> externalReference;
    @OneToMany
    @JoinColumn(name = "ServiceOrder_MVO_id")
    @JsonManagedReference
    private List<ServiceOrderItem_MVO> serviceOrderItem;
    @JsonProperty("@baseType")
    private String baseType;
    private String notificationContact;
    private OffsetDateTime completionDate;
    private OffsetDateTime expectedCompletionDate;
    private String href;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ServiceOrderStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String category;
    @OneToMany
    @JoinColumn(name = "ServiceOrder_MVO_id")
    @JsonManagedReference
    private List<ServiceOrderRelationship_MVO> orderRelationship;
    private OffsetDateTime startDate;
    private OffsetDateTime cancellationDate;
    private OffsetDateTime requestedCompletionDate;
}
