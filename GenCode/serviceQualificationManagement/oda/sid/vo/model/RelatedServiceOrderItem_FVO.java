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
import oda.sid.vo.model.Extensible_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedServiceOrderItem_FVO extends Extensible_FVO implements java.io.Serializable {
    private String serviceOrderHref;
    private String itemId;
    @JsonProperty("@referredType")
    private String referredType;
    private String role;
    @ManyToOne
    @JoinColumn(name = "itemAction_id")
    @JsonBackReference
    private OrderItemActionType itemAction;
    private String serviceOrderId;
}
