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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReserveProductStockItem implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "requestedProduct_id")
    @JsonBackReference
    private ProductRefOrValue requestedProduct;
    @ManyToOne
    @JoinColumn(name = "quantityRequested_id")
    @JsonBackReference
    private Quantity quantityRequested;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "productStockRequested_id")
    @JsonBackReference
    private ProductStockRef productStockRequested;
    @ManyToOne
    @JoinColumn(name = "productStockReserved_id")
    @JsonBackReference
    private ProductStockRef productStockReserved;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "quantityReserved_id")
    @JsonBackReference
    private Quantity quantityReserved;
    @ManyToOne
    @JoinColumn(name = "reserveProductStockState_id")
    @JsonBackReference
    private TaskStateType reserveProductStockState;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
