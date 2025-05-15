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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category_MVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private CategoryRef_MVO parent;
    @OneToMany
    @JoinColumn(name = "Category_MVO_id")
    @JsonManagedReference
    private List<CategoryRef_MVO> subCategory;
    @JsonProperty("@baseType")
    private String baseType;
    private Boolean isRoot;
    private String lifecycleStatus;
    @OneToMany
    @JoinColumn(name = "Category_MVO_id")
    @JsonManagedReference
    private List<ProductOfferingRef_MVO> productOffering;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String description;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String version;
}
