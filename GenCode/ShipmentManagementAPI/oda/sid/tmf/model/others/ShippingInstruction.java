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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingInstruction implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private String carrierId;
    private String carrierServiceCode;
    private Integer deliveryAttempts;
    private String deliverySpeed;
    private String receiptConfirmation;
    private String shippingType;
    private String warehouseId;
    @OneToMany
    @JoinColumn(name = "ShippingInstruction_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
