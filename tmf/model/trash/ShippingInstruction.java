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
public class ShippingInstruction implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ShippingInstruction_id")
    @JsonManagedReference
    private List<Note> note;
    @JsonProperty("@type")
    private String type;
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
    @JsonProperty("@baseType")
    private String baseType;
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
    private String href;
    @Id
    private String id;
    private String deliverySpeed;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String carrierId;
}
