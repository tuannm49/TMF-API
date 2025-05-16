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
import oda.sid.vo.model.Extensible_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkOrderItem_MVO extends Extensible_MVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonBackReference
    private Note_MVO note;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRef_MVO product;
    @ManyToOne
    @JoinColumn(name = "work_id")
    @JsonBackReference
    private WorkRefOrValue_MVO work;
    @OneToMany
    @JoinColumn(name = "WorkOrderItem_MVO_id")
    @JsonManagedReference
    private List<OrderPrice_MVO> itemTotalPrice;
    @OneToMany
    @JoinColumn(name = "WorkOrderItem_MVO_id")
    @JsonManagedReference
    private List<RelatedEntity_MVO> relatedEntity;
    @OneToMany
    @JoinColumn(name = "WorkOrderItem_MVO_id")
    @JsonManagedReference
    private List<OrderItemRelationship_MVO> workOrderItemRelationship;
    private String description;
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonBackReference
    private AppointmentRef_MVO appointment;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef_MVO billingAccount;
    @OneToMany
    @JoinColumn(name = "WorkOrderItem_MVO_id")
    @JsonManagedReference
    private List<ProductOrderItemRef_MVO> productOrderItem;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private OrderItemActionType action;
    @OneToMany
    @JoinColumn(name = "WorkOrderItem_MVO_id")
    @JsonManagedReference
    private List<OrderPrice_MVO> itemPrice;
    @OneToMany
    @JoinColumn(name = "WorkOrderItem_MVO_id")
    @JsonManagedReference
    private List<PaymentRef_MVO> payment;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private WorkOrderItemStateType state;
    @OneToMany
    @JoinColumn(name = "WorkOrderItem_MVO_id")
    @JsonManagedReference
    private List<WorkOrderItem_MVO> workOrderItem;
}
