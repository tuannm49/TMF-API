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
public class FeatureSpecification_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "FeatureSpecification_MVO_id")
    @JsonManagedReference
    private List<FeatureSpecificationRelationship_MVO> featureSpecRelationship;
    private Boolean isEnabled;
    @OneToMany
    @JoinColumn(name = "FeatureSpecification_MVO_id")
    @JsonManagedReference
    private List<PolicyRef_MVO> policyConstraint;
    private String name;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String version;
    @OneToMany
    @JoinColumn(name = "FeatureSpecification_MVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_MVO> featureSpecCharacteristic;
}
