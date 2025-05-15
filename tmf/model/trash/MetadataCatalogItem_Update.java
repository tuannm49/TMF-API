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
public class MetadataCatalogItem_Update implements java.io.Serializable {
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "specification_id")
    @JsonBackReference
    private MetadataSpecificationRef specification;
    private String lifecycleStatus;
    @OneToMany
    @JoinColumn(name = "MetadataCatalogItem_Update_id")
    @JsonManagedReference
    private List<MetadataCategoryRef> category;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
}
