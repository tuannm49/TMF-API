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
import oda.sid.vo.model.Extensible_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductConfiguration_FVO extends Extensible_FVO implements java.io.Serializable {
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
    private Boolean isSelected;
    @OneToMany
    @JoinColumn(name = "ProductConfiguration_FVO_id")
    @JsonManagedReference
    private List<ProductConfiguration_FVO> productConfiguration;
    @ManyToOne
    @JoinColumn(name = "bundledGroupProductOffering_id")
    @JsonBackReference
    private BundledGroupProductOffering_FVO bundledGroupProductOffering;
    private String id;
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
