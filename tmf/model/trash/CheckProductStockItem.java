package com.example.trash;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckProductStockItem implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    private Boolean provideAlternative;
    @OneToMany
    @JoinColumn(name = "CheckProductStockItem_id")
    @JsonManagedReference
    private List<AlternateProductStock> alternate;
    @ManyToOne
    @JoinColumn(name = "requestedQuantity_id")
    @JsonBackReference
    private Quantity requestedQuantity;
    @ManyToOne
    @JoinColumn(name = "checkedProductStock_id")
    @JsonBackReference
    private ProductStock checkedProductStock;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String availabilityResult;
}
