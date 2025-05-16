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
import oda.sid.tmf.model.product.DCSProductOrderItem;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiProductOrderItemAdd extends DCSProductOrderItem implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRef product;
    private String id;
    @OneToMany
    @JoinColumn(name = "ApiProductOrderItemAdd_id")
    @JsonManagedReference
    private List<ProductOfferingTermOrCondition> approvedProductOfferingTermOrCondition;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ProductOrderItemStateType state;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef productOffering;
    @ManyToOne
    @JoinColumn(name = "productAction_id")
    @JsonBackReference
    private ApiProductActionAdd productAction;
}
