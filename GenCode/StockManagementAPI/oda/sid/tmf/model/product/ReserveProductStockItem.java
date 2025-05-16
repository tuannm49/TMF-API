package oda.sid.tmf.model.product;

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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReserveProductStockItem implements java.io.Serializable {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "productStockRequested_id")
    @JsonBackReference
    private ProductStockRef productStockRequested;
    @ManyToOne
    @JoinColumn(name = "productStockReserved_id")
    @JsonBackReference
    private ProductStockRef productStockReserved;
    @ManyToOne
    @JoinColumn(name = "quantityRequested_id")
    @JsonBackReference
    private Quantity quantityRequested;
    @ManyToOne
    @JoinColumn(name = "quantityReserved_id")
    @JsonBackReference
    private Quantity quantityReserved;
    @ManyToOne
    @JoinColumn(name = "requestedProduct_id")
    @JsonBackReference
    private ProductRefOrValue requestedProduct;
    @ManyToOne
    @JoinColumn(name = "reserveProductStockState_id")
    @JsonBackReference
    private TaskStateType reserveProductStockState;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
