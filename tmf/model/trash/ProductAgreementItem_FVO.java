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
public class ProductAgreementItem_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ProductAgreementItem_FVO_id")
    @JsonManagedReference
    private List<AgreementTermOrCondition_FVO> termOrCondition;
    @OneToMany
    @JoinColumn(name = "ProductAgreementItem_FVO_id")
    @JsonManagedReference
    private List<ProductRef> product;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "ProductAgreementItem_FVO_id")
    @JsonManagedReference
    private List<ProductOfferingRef> productOffering;
    @JsonProperty("@type")
    private String type;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
