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
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cdr_MVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "amount_id")
    @JsonBackReference
    private Money amount;
    @ManyToOne
    @JoinColumn(name = "cdrDirectionType_id")
    @JsonBackReference
    private CdrDirectionType cdrDirectionType;
    private Boolean isTaxExempt;
    private String offerTariffType;
    private String description;
    private OffsetDateTime cdrDate;
    @ManyToOne
    @JoinColumn(name = "taxExcludedRatingAmount_id")
    @JsonBackReference
    private Money taxExcludedRatingAmount;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_MVO relatedParty;
    @OneToMany
    @JoinColumn(name = "Cdr_MVO_id")
    @JsonManagedReference
    private List<CdrCharacteristic_MVO> cdrCharacteristic;
    private Object taxRate;
    private Boolean isBilled;
    private OffsetDateTime ratingDate;
    private String cdrType;
    @ManyToOne
    @JoinColumn(name = "productRef_id")
    @JsonBackReference
    private ProductRef_MVO productRef;
    private String ratingAmountType;
    @ManyToOne
    @JoinColumn(name = "taxIncludedRatingAmount_id")
    @JsonBackReference
    private Money taxIncludedRatingAmount;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private CdrStatusType status;
    @OneToMany
    @JoinColumn(name = "Cdr_MVO_id")
    @JsonManagedReference
    private List<RatedCdr_MVO> ratedCdr;
}
