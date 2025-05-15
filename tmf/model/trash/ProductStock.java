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
public class ProductStock implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ProductStock_id")
    @JsonManagedReference
    private List<ProductStockRelationship> productStockRelationship;
    private String stockLevelCategory;
    @ManyToOne
    @JoinColumn(name = "stockLevelAlert_id")
    @JsonBackReference
    private Quantity stockLevelAlert;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ProductStock_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    private String description;
    @ManyToOne
    @JoinColumn(name = "reorderQuantity_id")
    @JsonBackReference
    private Quantity reorderQuantity;
    @ManyToOne
    @JoinColumn(name = "productStockUsageType_id")
    @JsonBackReference
    private ProductStockUsageType productStockUsageType;
    @JsonProperty("@baseType")
    private String baseType;
    @Id
    private String id;
    private String href;
    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue place;
    @ManyToOne
    @JoinColumn(name = "stockedProduct_id")
    @JsonBackReference
    private ProductRefOrValue stockedProduct;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "minStockLevel_id")
    @JsonBackReference
    private Quantity minStockLevel;
    private OffsetDateTime lastInventoryDate;
    private OffsetDateTime replenishmentDate;
    @OneToMany
    @JoinColumn(name = "ProductStock_id")
    @JsonManagedReference
    private List<MarketSegmentRef> marketSegment;
    @OneToMany
    @JoinColumn(name = "ProductStock_id")
    @JsonManagedReference
    private List<ResourceRef> resource;
    @ManyToOne
    @JoinColumn(name = "productStockLevel_id")
    @JsonBackReference
    private Quantity productStockLevel;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "ProductStock_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "maxStockLevel_id")
    @JsonBackReference
    private Quantity maxStockLevel;
    @ManyToOne
    @JoinColumn(name = "productStockStatusType_id")
    @JsonBackReference
    private ProductStockStatusType productStockStatusType;
    private OffsetDateTime lastUpdate;
    private String name;
}
