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
public class QueryProductRecommendation implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "QueryProductRecommendation_id")
    @JsonManagedReference
    private List<RecommendationItem> recommendationItem;
    @OneToMany
    @JoinColumn(name = "QueryProductRecommendation_id")
    @JsonManagedReference
    private List<ItemRef> shoppingCartItem;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "QueryProductRecommendation_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    private String description;
    @OneToMany
    @JoinColumn(name = "QueryProductRecommendation_id")
    @JsonManagedReference
    private List<ProductOrderRef> productOrder;
    @OneToMany
    @JoinColumn(name = "QueryProductRecommendation_id")
    @JsonManagedReference
    private List<ItemRef> productOrderItem;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private RelatedParty relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    private Boolean instantSyncRecommendation;
    private String name;
    @OneToMany
    @JoinColumn(name = "QueryProductRecommendation_id")
    @JsonManagedReference
    private List<ShoppingCartRef> shoppingCart;
    @Id
    private String id;
    private String href;
    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue place;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    private String recommendationType;
    @OneToMany
    @JoinColumn(name = "QueryProductRecommendation_id")
    @JsonManagedReference
    private List<CategoryRef> category;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
