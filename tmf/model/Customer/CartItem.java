package com.example.Customer;

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
public class CartItem implements java.io.Serializable {
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
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "CartItem_id")
    @JsonManagedReference
    private List<CartPrice> itemTotalPrice;
    @OneToMany
    @JoinColumn(name = "CartItem_id")
    @JsonManagedReference
    private List<CartItem> cartItem;
    @OneToMany
    @JoinColumn(name = "CartItem_id")
    @JsonManagedReference
    private List<CartTerm> itemTerm;
    @JsonProperty("@baseType")
    private String baseType;
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
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private CartItemStatusType status;
}
