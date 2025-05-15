package com.example.Common;

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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RatedProductUsage implements java.io.Serializable {
    private Boolean isTaxExempt;
    @JsonProperty("@type")
    private String type;
    private String offerTariffType;
    @ManyToOne
    @JoinColumn(name = "taxExcludedRatingAmount_id")
    @JsonBackReference
    private Money taxExcludedRatingAmount;
    private Object taxRate;
    private Boolean isBilled;
    private OffsetDateTime ratingDate;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "productRef_id")
    @JsonBackReference
    private ProductRef productRef;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String ratingAmountType;
    private String usageRatingTag;
    @ManyToOne
    @JoinColumn(name = "bucketValueConvertedInAmount_id")
    @JsonBackReference
    private Money bucketValueConvertedInAmount;
    @ManyToOne
    @JoinColumn(name = "taxIncludedRatingAmount_id")
    @JsonBackReference
    private Money taxIncludedRatingAmount;
}
