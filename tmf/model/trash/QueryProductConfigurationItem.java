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
public class QueryProductConfigurationItem implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "QueryProductConfigurationItem_id")
    @JsonManagedReference
    private List<ProductConfigurationItemRelationship> productConfigurationItemRelationship;
    @OneToMany
    @JoinColumn(name = "QueryProductConfigurationItem_id")
    @JsonManagedReference
    private List<QueryProductConfigurationItem> queryProductConfigurationItem;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "productConfiguration_id")
    @JsonBackReference
    private ProductConfiguration productConfiguration;
    @Id
    private String id;
    private String state;
    @ManyToOne
    @JoinColumn(name = "contextItem_id")
    @JsonBackReference
    private ItemRef contextItem;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "QueryProductConfigurationItem_id")
    @JsonManagedReference
    private List<StateReason> stateReason;
}
