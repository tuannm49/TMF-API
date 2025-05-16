package oda.sid.tmf.model.common;

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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RatedProductUsage implements java.io.Serializable {
    private Boolean isBilled;
    private Boolean isTaxExempt;
    private String offerTariffType;
    private String ratingAmountType;
    private OffsetDateTime ratingDate;
    private Object taxRate;
    private String usageRatingTag;
    @ManyToOne
    @JoinColumn(name = "bucketValueConvertedInAmount_id")
    @JsonBackReference
    private Money bucketValueConvertedInAmount;
    @ManyToOne
    @JoinColumn(name = "productRef_id")
    @JsonBackReference
    private ProductRef productRef;
    @ManyToOne
    @JoinColumn(name = "taxExcludedRatingAmount_id")
    @JsonBackReference
    private Money taxExcludedRatingAmount;
    @ManyToOne
    @JoinColumn(name = "taxIncludedRatingAmount_id")
    @JsonBackReference
    private Money taxIncludedRatingAmount;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
