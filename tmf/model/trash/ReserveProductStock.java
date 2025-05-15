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
public class ReserveProductStock implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ReserveProductStock_id")
    @JsonManagedReference
    private List<RelatedEntity> relatedEntity;
    private OffsetDateTime requiredAvailabilityDate;
    @OneToMany
    @JoinColumn(name = "ReserveProductStock_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "ReserveProductStock_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @OneToMany
    @JoinColumn(name = "ReserveProductStock_id")
    @JsonManagedReference
    private List<ReserveProductStockItem> reserveProductStockItem;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "reserveProductStockState_id")
    @JsonBackReference
    private TaskStateType reserveProductStockState;
    @Id
    private String id;
    private String href;
    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue place;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "ReserveProductStock_id")
    @JsonManagedReference
    private List<MarketSegmentRef> marketSegment;
}
