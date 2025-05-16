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
import oda.sid.vo.model.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceOrder_MVO extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ServiceOrder_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    private String cancellationReason;
    @OneToMany
    @JoinColumn(name = "ServiceOrder_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> orderCharacteristic;
    @JsonProperty("@type")
    private String type;
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
    private String notificationContact;
    private OffsetDateTime completionDate;
    private OffsetDateTime expectedCompletionDate;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ServiceOrderStateType state;
    private String category;
    @OneToMany
    @JoinColumn(name = "ServiceOrder_MVO_id")
    @JsonManagedReference
    private List<ServiceOrderRelationship_MVO> orderRelationship;
    private OffsetDateTime startDate;
    private OffsetDateTime cancellationDate;
    private OffsetDateTime requestedCompletionDate;
}
