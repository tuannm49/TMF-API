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
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category_allOf implements java.io.Serializable {
    private String description;
    private Boolean isRoot;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private CategoryRef parent;
    @OneToMany
    @JoinColumn(name = "Category_allOf_id")
    @JsonManagedReference
    private List<ProductOfferingRef> productOffering;
    @OneToMany
    @JoinColumn(name = "Category_allOf_id")
    @JsonManagedReference
    private List<CategoryRef> subCategory;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String version;
    private OffsetDateTime lastUpdate;
    private String lifecycleStatus;
    private String name;
}
