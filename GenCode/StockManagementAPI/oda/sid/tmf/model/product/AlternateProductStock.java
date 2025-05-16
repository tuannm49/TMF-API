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
import java.time.OffsetDateTime;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlternateProductStock implements java.io.Serializable {
    @Id
    private String id;
    private OffsetDateTime alternateAvailabilityDate;
    @ManyToOne
    @JoinColumn(name = "alternatePlace_id")
    @JsonBackReference
    private PlaceRefOrValue alternatePlace;
    @ManyToOne
    @JoinColumn(name = "alternateProduct_id")
    @JsonBackReference
    private ProductRefOrValue alternateProduct;
    @ManyToOne
    @JoinColumn(name = "alternateQuantity_id")
    @JsonBackReference
    private Quantity alternateQuantity;
    @ManyToOne
    @JoinColumn(name = "alternateStock_id")
    @JsonBackReference
    private ProductStockRef alternateStock;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
