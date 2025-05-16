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
import oda.sid.vo.model.JeopardyAlert_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOrderJeopardyAlert_FVO extends JeopardyAlert_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ProductOrderJeopardyAlert_FVO_id")
    @JsonManagedReference
    private List<ProductOrderItemRef_FVO> productOrderItem;
}
