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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckProductStockItem implements java.io.Serializable {
    @Id
    private String id;
    private String availabilityResult;
    private Boolean provideAlternative;
    @OneToMany
    @JoinColumn(name = "CheckProductStockItem_id")
    @JsonManagedReference
    private List<AlternateProductStock> alternate;
    @ManyToOne
    @JoinColumn(name = "checkedProductStock_id")
    @JsonBackReference
    private ProductStock checkedProductStock;
    @ManyToOne
    @JoinColumn(name = "requestedQuantity_id")
    @JsonBackReference
    private Quantity requestedQuantity;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
