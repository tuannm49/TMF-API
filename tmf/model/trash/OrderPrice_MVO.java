package com.example.trash;

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
public class OrderPrice_MVO implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    private String unitOfMeasure;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "price_id")
    @JsonBackReference
    private Price_MVO price;
    private String name;
    private String priceType;
    private String description;
    @ManyToOne
    @JoinColumn(name = "productOfferingPrice_id")
    @JsonBackReference
    private ProductOfferingPriceRef_MVO productOfferingPrice;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String recurringChargePeriod;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef_MVO billingAccount;
    @OneToMany
    @JoinColumn(name = "OrderPrice_MVO_id")
    @JsonManagedReference
    private List<PriceAlteration_MVO> priceAlteration;
}
