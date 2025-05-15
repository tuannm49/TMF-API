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
public class PromotionAction implements java.io.Serializable {
    private String actionType;
    @ManyToOne
    @JoinColumn(name = "actionEntityRef_id")
    @JsonBackReference
    private EntityRef actionEntityRef;
    @JsonProperty("@baseType")
    private String baseType;
    private String actionValue;
    @JsonProperty("@type")
    private String type;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
