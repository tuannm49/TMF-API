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
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cdr_MVO implements java.io.Serializable {
    private OffsetDateTime cdrDate;
    private String description;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private CdrStatusType status;
    private String cdrType;
    @OneToMany
    @JoinColumn(name = "Cdr_MVO_id")
    @JsonManagedReference
    private List<CdrCharacteristic_MVO> cdrCharacteristic;
    @ManyToOne
    @JoinColumn(name = "cdrDirectionType_id")
    @JsonBackReference
    private CdrDirectionType cdrDirectionType;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_MVO relatedParty;
    @OneToMany
    @JoinColumn(name = "Cdr_MVO_id")
    @JsonManagedReference
    private List<RatedCdr_MVO> ratedCdr;
    private Boolean isBilled;
    private String offerTariffType;
    private String ratingAmountType;
    @ManyToOne
    @JoinColumn(name = "amount_id")
    @JsonBackReference
    private Money amount;
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
