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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlternateProductStock implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "alternatePlace_id")
    @JsonBackReference
    private PlaceRefOrValue alternatePlace;
    @ManyToOne
    @JoinColumn(name = "alternateStock_id")
    @JsonBackReference
    private ProductStockRef alternateStock;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "alternateQuantity_id")
    @JsonBackReference
    private Quantity alternateQuantity;
    private OffsetDateTime alternateAvailabilityDate;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "alternateProduct_id")
    @JsonBackReference
    private ProductRefOrValue alternateProduct;
}
