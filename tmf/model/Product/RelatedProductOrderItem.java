package com.example.Product;

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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedProductOrderItem implements java.io.Serializable {
    @JsonProperty("@referredType")
    private String referredType;
    private String role;
    private String productOrderHref;
    @JsonProperty("@baseType")
    private String baseType;
    private String orderItemId;
    @JsonProperty("@type")
    private String type;
    private String productOrderId;
    @Id
    private String id;
    private String href;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String orderItemAction;
}
