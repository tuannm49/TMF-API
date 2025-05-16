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
public class ShippingOrder_FVO extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ShippingOrder_FVO_id")
    @JsonManagedReference
    private List<Note_FVO> note;
    @OneToMany
    @JoinColumn(name = "ShippingOrder_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> shippingOrderCharacteristic;
    @ManyToOne
    @JoinColumn(name = "productOrderRef_id")
    @JsonBackReference
    private ProductOrderRef_FVO productOrderRef;
    @ManyToOne
    @JoinColumn(name = "shippingOrderPrice_id")
    @JsonBackReference
    private Price shippingOrderPrice;
    @ManyToOne
    @JoinColumn(name = "placeTo_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue_FVO placeTo;
    @ManyToOne
    @JoinColumn(name = "shippingInstruction_id")
    @JsonBackReference
    private ShippingInstruction_FVO shippingInstruction;
    @ManyToOne
    @JoinColumn(name = "relatedShippingOrder_id")
    @JsonBackReference
    private RelatedShippingOrder_FVO relatedShippingOrder;
    @OneToMany
    @JoinColumn(name = "ShippingOrder_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_FVO> relatedParty;
    @ManyToOne
    @JoinColumn(name = "shippingOrderOffering_id")
    @JsonBackReference
    private ProductOfferingRef_FVO shippingOrderOffering;
    private OffsetDateTime lastUpdate;
    private OffsetDateTime completionDate;
    @OneToMany
    @JoinColumn(name = "ShippingOrder_FVO_id")
    @JsonManagedReference
    private List<ShippingOrderItem_FVO> shippingOrderItem;
    @ManyToOne
    @JoinColumn(name = "placeFrom_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue_FVO placeFrom;
}
