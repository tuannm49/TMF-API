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
import oda.sid.vo.model.EntitySpecification_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductTestSpecification_MVO extends EntitySpecification_MVO implements java.io.Serializable {
    private String description;
    @OneToMany
    @JoinColumn(name = "ProductTestSpecification_MVO_id")
    @JsonManagedReference
    private List<ProductSpecificationRef_MVO> relatedProductSpecification;
    @OneToMany
    @JoinColumn(name = "ProductTestSpecification_MVO_id")
    @JsonManagedReference
    private List<ProductTestSpecRelationship_MVO> productTestSpecRelationship;
    @OneToMany
    @JoinColumn(name = "ProductTestSpecification_MVO_id")
    @JsonManagedReference
    private List<TestMeasureDefinition_MVO> testMeasureDefinition;
}
