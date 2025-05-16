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
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRefOrValue implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private String buyerProductId;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductRefOrValue_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue> place;
    @OneToMany
    @JoinColumn(name = "ProductRefOrValue_id")
    @JsonManagedReference
    private List<Characteristic> productCharacteristic;
    @OneToMany
    @JoinColumn(name = "ProductRefOrValue_id")
    @JsonManagedReference
    private List<ProductRelationship> productRelationship;
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef productSpecification;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
    @JsonProperty("@referredType")
    private String referredType;
}
