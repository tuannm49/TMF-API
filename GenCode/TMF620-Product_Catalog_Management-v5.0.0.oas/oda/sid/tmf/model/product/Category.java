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
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.tmf.model.product.Entity;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category extends Entity implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private CategoryRef parent;
    @OneToMany
    @JoinColumn(name = "Category_id")
    @JsonManagedReference
    private List<CategoryRef> subCategory;
    private Boolean isRoot;
    private String lifecycleStatus;
    @OneToMany
    @JoinColumn(name = "Category_id")
    @JsonManagedReference
    private List<ProductOfferingRef> productOffering;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private OffsetDateTime lastUpdate;
    private String name;
    private String description;
    private String version;
}
