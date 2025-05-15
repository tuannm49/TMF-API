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
public class CharacteristicSpecification_MVO_allOf implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@valueSchemaLocation")
    private String valueSchemaLocation;
    private Boolean isUnique;
    private String description;
    private Integer maxCardinality;
    private Integer minCardinality;
    private String regex;
    private String valueType;
    @OneToMany
    @JoinColumn(name = "CharacteristicSpecification_MVO_allOf_id")
    @JsonManagedReference
    private List<CharacteristicSpecificationRelationship_MVO> charSpecRelationship;
    @OneToMany
    @JoinColumn(name = "CharacteristicSpecification_MVO_allOf_id")
    @JsonManagedReference
    private List<CharacteristicValueSpecification_MVO> characteristicValueSpecification;
    private String name;
    @Id
    private String id;
    private Boolean extensible;
    private Boolean configurable;
}
