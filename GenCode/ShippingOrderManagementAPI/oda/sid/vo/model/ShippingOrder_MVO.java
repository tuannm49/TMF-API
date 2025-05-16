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
public class ShippingOrder_MVO extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ShippingOrder_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    @OneToMany
    @JoinColumn(name = "ShippingOrder_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> shippingOrderCharacteristic;
    @ManyToOne
    @JoinColumn(name = "productOrderRef_id")
    @JsonBackReference
    private ProductOrderRef_MVO productOrderRef;
    @ManyToOne
    @JoinColumn(name = "shippingOrderPrice_id")
    @JsonBackReference
    private Price_MVO shippingOrderPrice;
    @ManyToOne
    @JoinColumn(name = "placeTo_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue_MVO placeTo;
    @ManyToOne
    @JoinColumn(name = "shippingInstruction_id")
    @JsonBackReference
    private ShippingInstruction_MVO shippingInstruction;
    @ManyToOne
    @JoinColumn(name = "relatedShippingOrder_id")
    @JsonBackReference
    private RelatedShippingOrder_MVO relatedShippingOrder;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "ShippingOrder_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> relatedParty;
    @ManyToOne
    @JoinColumn(name = "shippingOrderOffering_id")
    @JsonBackReference
    private ProductOfferingRef_MVO shippingOrderOffering;
    private OffsetDateTime lastUpdate;
    private OffsetDateTime completionDate;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ShippingOrderStateType state;
    @OneToMany
    @JoinColumn(name = "ShippingOrder_MVO_id")
    @JsonManagedReference
    private List<ShippingOrderItem_MVO> shippingOrderItem;
    @ManyToOne
    @JoinColumn(name = "placeFrom_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue_MVO placeFrom;
}
