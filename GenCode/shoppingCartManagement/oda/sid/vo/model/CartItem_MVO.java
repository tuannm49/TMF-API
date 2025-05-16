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
public class CartItem_MVO extends Extensible implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CartItem_MVO_id")
    @JsonManagedReference
    private List<CartTerm_MVO> itemTerm;
    @OneToMany
    @JoinColumn(name = "CartItem_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue_MVO product;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef_MVO productOffering;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private CartItemActionType action;
    @OneToMany
    @JoinColumn(name = "CartItem_MVO_id")
    @JsonManagedReference
    private List<CartItemRelationship_MVO> cartItemRelationship;
    @OneToMany
    @JoinColumn(name = "CartItem_MVO_id")
    @JsonManagedReference
    private List<CartPrice_MVO> itemPrice;
    private String id;
    @OneToMany
    @JoinColumn(name = "CartItem_MVO_id")
    @JsonManagedReference
    private List<CartItem_MVO> cartItem;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private CartItemStatusType status;
}
