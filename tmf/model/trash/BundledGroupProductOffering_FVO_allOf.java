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
public class BundledGroupProductOffering_FVO_allOf implements java.io.Serializable {
    private String name;
    @OneToMany
    @JoinColumn(name = "BundledGroupProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<BundledGroupProductOffering_FVO> bundledGroupProductOffering;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "BundledGroupProductOffering_FVO_allOf_id")
    @JsonManagedReference
    private List<BundledProductOffering_FVO> bundledProductOffering;
    @ManyToOne
    @JoinColumn(name = "bundledGroupProductOfferingOption_id")
    @JsonBackReference
    private BundledGroupProductOfferingOption_FVO bundledGroupProductOfferingOption;
}
