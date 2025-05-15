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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntityCatalogItem_Create implements java.io.Serializable {
    private String lifecycleStatus;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private OffsetDateTime lastUpdate;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "specification_id")
    @JsonBackReference
    private EntitySpecificationRef specification;
    @OneToMany
    @JoinColumn(name = "EntityCatalogItem_Create_id")
    @JsonManagedReference
    private List<EntityCategoryRef> category;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String version;
}
