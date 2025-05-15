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
public class Feature_FVO implements java.io.Serializable {
    private Boolean isBundle;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    private Boolean isEnabled;
    @OneToMany
    @JoinColumn(name = "Feature_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> featureCharacteristic;
    @OneToMany
    @JoinColumn(name = "Feature_FVO_id")
    @JsonManagedReference
    private List<PolicyRef_FVO> policyConstraint;
    private String name;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Feature_FVO_id")
    @JsonManagedReference
    private List<FeatureRelationship_FVO> featureRelationship;
}
