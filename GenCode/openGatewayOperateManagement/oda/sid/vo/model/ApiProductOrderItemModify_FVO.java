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
import oda.sid.vo.model.DCSProductOrderItem;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiProductOrderItemModify_FVO extends DCSProductOrderItem implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRef_FVO product;
    private String id;
    @OneToMany
    @JoinColumn(name = "ApiProductOrderItemModify_FVO_id")
    @JsonManagedReference
    private List<ProductOfferingTermOrCondition_FVO> approvedProductOfferingTermOrCondition;
    @ManyToOne
    @JoinColumn(name = "productAction_id")
    @JsonBackReference
    private ApiProductActionModify_FVO productAction;
}
