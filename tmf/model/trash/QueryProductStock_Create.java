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
public class QueryProductStock_Create implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "QueryProductStock_Create_id")
    @JsonManagedReference
    private List<ProductStock> queryProductStockItem;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "searchCriteria_id")
    @JsonBackReference
    private ProductStock searchCriteria;
    private OffsetDateTime completedQueryProductStockDate;
    @JsonProperty("@type")
    private String type;
    private OffsetDateTime requestedAvailabilityDate;
    private Boolean instantSyncCheck;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "QueryProductStock_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime requestedQueryProductStockDate;
}
