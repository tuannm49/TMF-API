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
public class ProductConfiguration_FVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef_FVO productSpecification;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue_FVO product;
    private Object quantity;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef_FVO productOffering;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ProductConfiguration_FVO_id")
    @JsonManagedReference
    private List<ConfigurationTerm_FVO> configurationTerm;
    @OneToMany
    @JoinColumn(name = "ProductConfiguration_FVO_id")
    @JsonManagedReference
    private List<ConfigurationPrice_FVO> configurationPrice;
    private Boolean isVisible;
    private String version;
    @OneToMany
    @JoinColumn(name = "ProductConfiguration_FVO_id")
    @JsonManagedReference
    private List<ConfigurationAction_FVO> configurationAction;
    @ManyToOne
    @JoinColumn(name = "bundledProductOfferingOption_id")
    @JsonBackReference
    private BundledProductOfferingOption_FVO bundledProductOfferingOption;
    @JsonProperty("@baseType")
    private String baseType;
    private Boolean isSelected;
    @OneToMany
    @JoinColumn(name = "ProductConfiguration_FVO_id")
    @JsonManagedReference
    private List<ProductConfiguration_FVO> productConfiguration;
    @ManyToOne
    @JoinColumn(name = "bundledGroupProductOffering_id")
    @JsonBackReference
    private BundledGroupProductOffering_FVO bundledGroupProductOffering;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private Boolean isSelectable;
    @OneToMany
    @JoinColumn(name = "ProductConfiguration_FVO_id")
    @JsonManagedReference
    private List<ConfigurationCharacteristic_FVO> configurationCharacteristic;
    @OneToMany
    @JoinColumn(name = "ProductConfiguration_FVO_id")
    @JsonManagedReference
    private List<PolicyRef_FVO> policy;
}
