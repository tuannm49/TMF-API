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
public class ProductStock_Create implements java.io.Serializable {
    private OffsetDateTime creationDate;
    private String description;
    private OffsetDateTime lastInventoryDate;
    private OffsetDateTime lastUpdate;
    private String name;
    private OffsetDateTime replenishmentDate;
    private String stockLevelCategory;
    @OneToMany
    @JoinColumn(name = "ProductStock_Create_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    @OneToMany
    @JoinColumn(name = "ProductStock_Create_id")
    @JsonManagedReference
    private List<MarketSegmentRef> marketSegment;
    @ManyToOne
    @JoinColumn(name = "maxStockLevel_id")
    @JsonBackReference
    private Quantity maxStockLevel;
    @ManyToOne
    @JoinColumn(name = "minStockLevel_id")
    @JsonBackReference
    private Quantity minStockLevel;
    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue place;
    @ManyToOne
    @JoinColumn(name = "productStockLevel_id")
    @JsonBackReference
    private Quantity productStockLevel;
    @OneToMany
    @JoinColumn(name = "ProductStock_Create_id")
    @JsonManagedReference
    private List<ProductStockRelationship> productStockRelationship;
    @ManyToOne
    @JoinColumn(name = "productStockStatusType_id")
    @JsonBackReference
    private ProductStockStatusType productStockStatusType;
    @ManyToOne
    @JoinColumn(name = "productStockUsageType_id")
    @JsonBackReference
    private ProductStockUsageType productStockUsageType;
    @OneToMany
    @JoinColumn(name = "ProductStock_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "reorderQuantity_id")
    @JsonBackReference
    private Quantity reorderQuantity;
    @OneToMany
    @JoinColumn(name = "ProductStock_Create_id")
    @JsonManagedReference
    private List<ResourceRef> resource;
    @ManyToOne
    @JoinColumn(name = "stockLevelAlert_id")
    @JsonBackReference
    private Quantity stockLevelAlert;
    @ManyToOne
    @JoinColumn(name = "stockedProduct_id")
    @JsonBackReference
    private ProductRefOrValue stockedProduct;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
