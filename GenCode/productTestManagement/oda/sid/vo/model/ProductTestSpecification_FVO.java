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
import oda.sid.vo.model.EntitySpecification_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductTestSpecification_FVO extends EntitySpecification_FVO implements java.io.Serializable {
    private String description;
    @OneToMany
    @JoinColumn(name = "ProductTestSpecification_FVO_id")
    @JsonManagedReference
    private List<ProductSpecificationRef_FVO> relatedProductSpecification;
    @OneToMany
    @JoinColumn(name = "ProductTestSpecification_FVO_id")
    @JsonManagedReference
    private List<ProductTestSpecRelationship_FVO> productTestSpecRelationship;
    @OneToMany
    @JoinColumn(name = "ProductTestSpecification_FVO_id")
    @JsonManagedReference
    private List<TestMeasureDefinition_FVO> testMeasureDefinition;
}
