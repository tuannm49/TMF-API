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
public class ProductConfiguration implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef productSpecification;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue product;
    private Object quantity;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef productOffering;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ProductConfiguration_id")
    @JsonManagedReference
    private List<ConfigurationTerm> configurationTerm;
    @OneToMany
    @JoinColumn(name = "ProductConfiguration_id")
    @JsonManagedReference
    private List<ConfigurationPrice> configurationPrice;
    private Boolean isVisible;
    private String version;
    @OneToMany
    @JoinColumn(name = "ProductConfiguration_id")
    @JsonManagedReference
    private List<ConfigurationAction> configurationAction;
    @ManyToOne
    @JoinColumn(name = "bundledProductOfferingOption_id")
    @JsonBackReference
    private BundledProductOfferingOption bundledProductOfferingOption;
    @JsonProperty("@baseType")
    private String baseType;
    private Boolean isSelected;
    @OneToMany
    @JoinColumn(name = "ProductConfiguration_id")
    @JsonManagedReference
    private List<ProductConfiguration> productConfiguration;
    @ManyToOne
    @JoinColumn(name = "bundledGroupProductOffering_id")
    @JsonBackReference
    private BundledGroupProductOffering bundledGroupProductOffering;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private Boolean isSelectable;
    @OneToMany
    @JoinColumn(name = "ProductConfiguration_id")
    @JsonManagedReference
    private List<ConfigurationCharacteristic> configurationCharacteristic;
    @OneToMany
    @JoinColumn(name = "ProductConfiguration_id")
    @JsonManagedReference
    private List<PolicyRef> policy;
}
