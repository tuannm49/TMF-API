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
public class EntityCategory_Create implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "EntityCategory_Create_id")
    @JsonManagedReference
    private List<EntityCatalogItemRef> entityCatalogItem;
    @OneToMany
    @JoinColumn(name = "EntityCategory_Create_id")
    @JsonManagedReference
    private List<EntityCategoryRef> childCategory;
    private Boolean isRoot;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String description;
    private String version;
    private String parentId;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime lastUpdate;
    private String name;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
