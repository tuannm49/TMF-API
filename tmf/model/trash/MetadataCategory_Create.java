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
public class MetadataCategory_Create implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "MetadataCategory_Create_id")
    @JsonManagedReference
    private List<EntityCategoryRef> childCategory;
    private Boolean isRoot;
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
    @OneToMany
    @JoinColumn(name = "MetadataCategory_Create_id")
    @JsonManagedReference
    private List<MetadataCatalogItemRef> MetadataCatalogItem;
    private String description;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String parentId;
}
