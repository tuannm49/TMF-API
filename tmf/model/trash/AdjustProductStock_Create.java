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
public class AdjustProductStock_Create implements java.io.Serializable {
    private OffsetDateTime completedAdjustProductStockDate;
    @OneToMany
    @JoinColumn(name = "AdjustProductStock_Create_id")
    @JsonManagedReference
    private List<AdjustProductStockItem> adjustProductStockItem;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime requestedAdjustProductStockDate;
    @JsonProperty("@type")
    private String type;
    private String description;
    private String adjustReason;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    private OffsetDateTime creationDate;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private Boolean instantSyncAdjust;
}
