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
import oda.sid.tmf.model.product.EntitySpecification;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductTestSpecification extends EntitySpecification implements java.io.Serializable {
    private String description;
    @OneToMany
    @JoinColumn(name = "ProductTestSpecification_id")
    @JsonManagedReference
    private List<ProductSpecificationRef> relatedProductSpecification;
    @OneToMany
    @JoinColumn(name = "ProductTestSpecification_id")
    @JsonManagedReference
    private List<ProductTestSpecRelationship> productTestSpecRelationship;
    @OneToMany
    @JoinColumn(name = "ProductTestSpecification_id")
    @JsonManagedReference
    private List<TestMeasureDefinition> testMeasureDefinition;
}
