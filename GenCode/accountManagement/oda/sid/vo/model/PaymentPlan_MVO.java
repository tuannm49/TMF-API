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
import oda.sid.vo.model.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentPlan_MVO extends Extensible implements java.io.Serializable {
    private Integer numberOfPayments;
    @ManyToOne
    @JoinColumn(name = "totalAmount_id")
    @JsonBackReference
    private Money totalAmount;
    private String planType;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @ManyToOne
    @JoinColumn(name = "paymentMethod_id")
    @JsonBackReference
    private PaymentMethodRef_MVO paymentMethod;
    private String id;
    private String paymentFrequency;
    private Integer priority;
    private String status;
}
