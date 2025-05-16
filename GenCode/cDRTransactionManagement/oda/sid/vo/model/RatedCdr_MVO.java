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
import java.time.OffsetDateTime;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RatedCdr_MVO implements java.io.Serializable {
    private Boolean isBilled;
    private String offerTariffType;
    private String ratingAmountType;
    private OffsetDateTime ratingDate;
    private Boolean isTaxExempt;
    @ManyToOne
    @JoinColumn(name = "productRef_id")
    @JsonBackReference
    private ProductRef_MVO productRef;
    @ManyToOne
    @JoinColumn(name = "taxExcludedRatingAmount_id")
    @JsonBackReference
    private Money taxExcludedRatingAmount;
    @ManyToOne
    @JoinColumn(name = "taxIncludedRatingAmount_id")
    @JsonBackReference
    private Money taxIncludedRatingAmount;
    private Object taxRate;
}
