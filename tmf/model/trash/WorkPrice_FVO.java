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
public class WorkPrice_FVO implements java.io.Serializable {
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
    @ManyToOne
    @JoinColumn(name = "priceType_id")
    @JsonBackReference
    private PriceType priceType;
    private String description;
    @ManyToOne
    @JoinColumn(name = "productOfferingPrice_id")
    @JsonBackReference
    private ProductOfferingPriceRef productOfferingPrice;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef billingAccount;
    private String recurringChargePeriod;
    @OneToMany
    @JoinColumn(name = "WorkPrice_FVO_id")
    @JsonManagedReference
    private List<PriceAlteration_FVO> priceAlteration;
}
