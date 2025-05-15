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
public class CheckProductStock implements java.io.Serializable {
    @JsonProperty("@type")
    private String type;
    private OffsetDateTime requestedAvailabilityDate;
    private Boolean provideAlternative;
    private OffsetDateTime completedCheckProductStockDate;
    private OffsetDateTime requestedCheckProductStockDate;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "CheckProductStock_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "CheckProductStock_id")
    @JsonManagedReference
    private List<CheckProductStockItem> checkProductStockItem;
    private Boolean instantSyncCheck;
    @Id
    private String id;
    private String href;
    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private PlaceRefOrValue place;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
