package com.example.Product;

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
public class ProductPrice implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    private String unitOfMeasure;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "price_id")
    @JsonBackReference
    private Price price;
    private String name;
    private String priceType;
    private String description;
    @ManyToOne
    @JoinColumn(name = "productOfferingPrice_id")
    @JsonBackReference
    private ProductOfferingPriceRef productOfferingPrice;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String recurringChargePeriod;
    @OneToMany
    @JoinColumn(name = "ProductPrice_id")
    @JsonManagedReference
    private List<PriceAlteration> priceAlteration;
}
