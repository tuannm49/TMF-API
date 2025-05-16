package oda.sid.tmf.model.service;

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
import oda.sid.tmf.model.service.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceOrder extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ServiceOrder_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "ServiceOrder_id")
    @JsonManagedReference
    private List<Characteristic> orderCharacteristic;
    @JsonProperty("@type")
    private String type;
    private String description;
    private OffsetDateTime requestedStartDate;
    @OneToMany
    @JoinColumn(name = "ServiceOrder_id")
    @JsonManagedReference
    private List<ServiceOrderItem> serviceOrderItem;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ServiceOrderStateType state;
    private String href;
    private String id;
    @OneToMany
    @JoinColumn(name = "ServiceOrder_id")
    @JsonManagedReference
    private List<ServiceOrderJeopardyAlert> jeopardyAlert;
    private OffsetDateTime cancellationDate;
    private OffsetDateTime requestedCompletionDate;
    private String cancellationReason;
    @ManyToOne
    @JoinColumn(name = "errorMessage_id")
    @JsonBackReference
    private ServiceOrderErrorMessage errorMessage;
    @ManyToOne
    @JoinColumn(name = "orderSpecification_id")
    @JsonBackReference
    private OrderSpecificationRef orderSpecification;
    private String priority;
    @OneToMany
    @JoinColumn(name = "ServiceOrder_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    @OneToMany
    @JoinColumn(name = "ServiceOrder_id")
    @JsonManagedReference
    private List<ExternalReference> externalReference;
    @OneToMany
    @JoinColumn(name = "ServiceOrder_id")
    @JsonManagedReference
    private List<ServiceOrderMilestone> milestone;
    private String notificationContact;
    private OffsetDateTime completionDate;
    private OffsetDateTime expectedCompletionDate;
    private String category;
    @OneToMany
    @JoinColumn(name = "ServiceOrder_id")
    @JsonManagedReference
    private List<ServiceOrderRelationship> orderRelationship;
    private OffsetDateTime orderDate;
    private OffsetDateTime startDate;
}
