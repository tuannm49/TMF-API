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
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShoppingCart implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ShoppingCart_id")
    @JsonManagedReference
    private List<ContactMedium> contactMedium;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private OffsetDateTime lastUpdate;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "ShoppingCart_id")
    @JsonManagedReference
    private List<CartPrice> cartTotalPrice;
    @OneToMany
    @JoinColumn(name = "ShoppingCart_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> relatedParty;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "ShoppingCart_id")
    @JsonManagedReference
    private List<CartItem> cartItem;
}
