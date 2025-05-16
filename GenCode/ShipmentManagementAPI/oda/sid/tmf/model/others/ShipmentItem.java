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
public class ShipmentItem implements java.io.Serializable {
    @Id
    private String id;
    private String quantity;
    private String sku;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private ShipmentItemActionType action;
    @OneToMany
    @JoinColumn(name = "ShipmentItem_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @OneToMany
    @JoinColumn(name = "ShipmentItem_id")
    @JsonManagedReference
    private List<ExternalReference> externalIdentifier;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue product;
    @ManyToOne
    @JoinColumn(name = "productReservationRef_id")
    @JsonBackReference
    private ReserveProductStockRef productReservationRef;
    @ManyToOne
    @JoinColumn(name = "productStockRef_id")
    @JsonBackReference
    private ProductStockRef productStockRef;
    @ManyToOne
    @JoinColumn(name = "shipmentItemPrice_id")
    @JsonBackReference
    private Price shipmentItemPrice;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
