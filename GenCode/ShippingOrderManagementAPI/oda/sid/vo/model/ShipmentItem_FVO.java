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
public class ShipmentItem_FVO extends Extensible implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue_FVO product;
    private String quantity;
    @ManyToOne
    @JoinColumn(name = "productReservationRef_id")
    @JsonBackReference
    private ReserveProductStockRef_FVO productReservationRef;
    @ManyToOne
    @JoinColumn(name = "productStockRef_id")
    @JsonBackReference
    private ProductStockRef_FVO productStockRef;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private ShipmentItemActionType action;
    @ManyToOne
    @JoinColumn(name = "weight_id")
    @JsonBackReference
    private Quantity weight;
    @OneToMany
    @JoinColumn(name = "ShipmentItem_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    private String id;
    private String sku;
    @ManyToOne
    @JoinColumn(name = "shipmentItemPrice_id")
    @JsonBackReference
    private Price shipmentItemPrice;
    @OneToMany
    @JoinColumn(name = "ShipmentItem_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> characteristic;
}
