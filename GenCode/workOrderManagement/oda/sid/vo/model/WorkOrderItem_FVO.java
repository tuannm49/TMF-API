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
import oda.sid.vo.model.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkOrderItem_FVO extends Extensible implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonBackReference
    private Note note;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRef product;
    @ManyToOne
    @JoinColumn(name = "work_id")
    @JsonBackReference
    private WorkRefOrValue_FVO work;
    @OneToMany
    @JoinColumn(name = "WorkOrderItem_FVO_id")
    @JsonManagedReference
    private List<OrderPrice_FVO> itemTotalPrice;
    @OneToMany
    @JoinColumn(name = "WorkOrderItem_FVO_id")
    @JsonManagedReference
    private List<RelatedEntity_FVO> relatedEntity;
    @OneToMany
    @JoinColumn(name = "WorkOrderItem_FVO_id")
    @JsonManagedReference
    private List<OrderItemRelationship_FVO> workOrderItemRelationship;
    private String description;
    @ManyToOne
    @JoinColumn(name = "appointment_id")
    @JsonBackReference
    private AppointmentRef appointment;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef billingAccount;
    @OneToMany
    @JoinColumn(name = "WorkOrderItem_FVO_id")
    @JsonManagedReference
    private List<ProductOrderItemRef_FVO> productOrderItem;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private OrderItemActionType action;
    @OneToMany
    @JoinColumn(name = "WorkOrderItem_FVO_id")
    @JsonManagedReference
    private List<OrderPrice_FVO> itemPrice;
    @OneToMany
    @JoinColumn(name = "WorkOrderItem_FVO_id")
    @JsonManagedReference
    private List<PaymentRef> payment;
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private WorkOrderItemStateType state;
    @OneToMany
    @JoinColumn(name = "WorkOrderItem_FVO_id")
    @JsonManagedReference
    private List<WorkOrderItem_FVO> workOrderItem;
}
