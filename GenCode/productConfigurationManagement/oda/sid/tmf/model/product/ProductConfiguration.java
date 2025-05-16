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
import java.util.List;
import oda.sid.tmf.model.product.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductConfiguration extends Extensible implements java.io.Serializable {
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
    private Boolean isSelected;
    @OneToMany
    @JoinColumn(name = "ProductConfiguration_id")
    @JsonManagedReference
    private List<ProductConfiguration> productConfiguration;
    @ManyToOne
    @JoinColumn(name = "bundledGroupProductOffering_id")
    @JsonBackReference
    private BundledGroupProductOffering bundledGroupProductOffering;
    private String id;
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
