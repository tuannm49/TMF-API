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
public class ReserveProductStock_Create implements java.io.Serializable {
    private OffsetDateTime creationDate;
    private OffsetDateTime requiredAvailabilityDate;
    @OneToMany
    @JoinColumn(name = "ReserveProductStock_Create_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    @OneToMany
    @JoinColumn(name = "ReserveProductStock_Create_id")
    @JsonManagedReference
    private List<MarketSegmentRef> marketSegment;
    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue place;
    @OneToMany
    @JoinColumn(name = "ReserveProductStock_Create_id")
    @JsonManagedReference
    private List<RelatedEntity> relatedEntity;
    @OneToMany
    @JoinColumn(name = "ReserveProductStock_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @OneToMany
    @JoinColumn(name = "ReserveProductStock_Create_id")
    @JsonManagedReference
    private List<ReserveProductStockItem> reserveProductStockItem;
    @ManyToOne
    @JoinColumn(name = "reserveProductStockState_id")
    @JsonBackReference
    private TaskStateType reserveProductStockState;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
