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
public class AdjustProductStock implements java.io.Serializable {
    private OffsetDateTime completedAdjustProductStockDate;
    private OffsetDateTime requestedAdjustProductStockDate;
    @JsonProperty("@type")
    private String type;
    private String description;
    private String adjustReason;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "AdjustProductStock_id")
    @JsonManagedReference
    private List<AdjustProductStockItem> adjustProductStockItem;
    @JsonProperty("@baseType")
    private String baseType;
    @Id
    private String id;
    private String href;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private Boolean instantSyncAdjust;
}
