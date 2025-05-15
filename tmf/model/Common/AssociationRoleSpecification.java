package com.example.Common;

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
public class AssociationRoleSpecification implements java.io.Serializable {
    private String role;
    private Integer minQuantity;
    @JsonProperty("@baseType")
    private String baseType;
    private Integer maxQuantity;
    private String entityType;
    @JsonProperty("@type")
    private String type;
    private Boolean isSource;
    private String aggregation;
    private Integer defaultQuantity;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private Boolean isNavigable;
}
