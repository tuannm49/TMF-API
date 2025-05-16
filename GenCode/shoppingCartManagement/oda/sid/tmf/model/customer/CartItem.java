package oda.sid.tmf.model.customer;

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
import oda.sid.tmf.model.customer.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartItem extends Extensible implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CartItem_id")
    @JsonManagedReference
    private List<CartTerm> itemTerm;
    @OneToMany
    @JoinColumn(name = "CartItem_id")
    @JsonManagedReference
    private List<Note> note;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue product;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef productOffering;
    @OneToMany
    @JoinColumn(name = "CartItem_id")
    @JsonManagedReference
    private List<CartPrice> itemTotalPrice;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private CartItemActionType action;
    @OneToMany
    @JoinColumn(name = "CartItem_id")
    @JsonManagedReference
    private List<CartItemRelationship> cartItemRelationship;
    @OneToMany
    @JoinColumn(name = "CartItem_id")
    @JsonManagedReference
    private List<CartPrice> itemPrice;
    private String id;
    @OneToMany
    @JoinColumn(name = "CartItem_id")
    @JsonManagedReference
    private List<CartItem> cartItem;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private CartItemStatusType status;
}
