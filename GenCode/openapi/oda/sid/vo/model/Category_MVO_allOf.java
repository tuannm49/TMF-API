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
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category_MVO_allOf implements java.io.Serializable {
    private String description;
    private Boolean isRoot;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private CategoryRef_MVO parent;
    @OneToMany
    @JoinColumn(name = "Category_MVO_allOf_id")
    @JsonManagedReference
    private List<ProductOfferingRef_MVO> productOffering;
    @OneToMany
    @JoinColumn(name = "Category_MVO_allOf_id")
    @JsonManagedReference
    private List<CategoryRef_MVO> subCategory;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String version;
    private String lifecycleStatus;
    private String name;
}
