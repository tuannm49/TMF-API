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
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOrderMilestone_MVO implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime milestoneDate;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String description;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String message;
    @OneToMany
    @JoinColumn(name = "ProductOrderMilestone_MVO_id")
    @JsonManagedReference
    private List<ProductOrderItemRef_MVO> productOrderItem;
    private String status;
}
