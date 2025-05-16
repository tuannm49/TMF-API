package oda.sid.tmf.model.others;

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
import oda.sid.tmf.model.others.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingInstruction extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ShippingInstruction_id")
    @JsonManagedReference
    private List<Note> note;
    private String shippingType;
    @ManyToOne
    @JoinColumn(name = "insuredValue_id")
    @JsonBackReference
    private Money insuredValue;
    @ManyToOne
    @JoinColumn(name = "signatureRequiredBy_id")
    @JsonBackReference
    private SignatureRequiredByType signatureRequiredBy;
    private String labelMessage;
    private String carrierServiceCode;
    private Integer deliveryAttempts;
    private String packageType;
    private String carrierName;
    @ManyToOne
    @JoinColumn(name = "deliveryTimeSlot_id")
    @JsonBackReference
    private TimePeriod deliveryTimeSlot;
    @OneToMany
    @JoinColumn(name = "ShippingInstruction_id")
    @JsonManagedReference
    private List<Characteristic> instructionCharacteristic;
    private String warehouseId;
    private String receiptConfirmation;
    private Boolean signatureRequired;
    private String deliverySpeed;
    private String carrierId;
}
