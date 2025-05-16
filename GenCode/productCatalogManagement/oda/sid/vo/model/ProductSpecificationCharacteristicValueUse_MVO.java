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
import oda.sid.vo.model.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductSpecificationCharacteristicValueUse_MVO extends Extensible implements java.io.Serializable {
    private Integer minCardinality;
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef_MVO productSpecification;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String valueType;
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "ProductSpecificationCharacteristicValueUse_MVO_id")
    @JsonManagedReference
    private List<CharacteristicValueSpecification_MVO> productSpecCharacteristicValue;
    private String id;
    private Integer maxCardinality;
}
