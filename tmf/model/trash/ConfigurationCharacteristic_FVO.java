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
public class ConfigurationCharacteristic_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ConfigurationCharacteristic_FVO_id")
    @JsonManagedReference
    private List<ConfigurationCharacteristicValue_FVO> configurationCharacteristicValue;
    private Boolean isConfigurable;
    @JsonProperty("@type")
    private String type;
    private String description;
    private Integer maxCardinality;
    @OneToMany
    @JoinColumn(name = "ConfigurationCharacteristic_FVO_id")
    @JsonManagedReference
    private List<ConfigurationCharacteristicRelationship_FVO> configurationCharacteristicRelationship;
    private Integer minCardinality;
    private String regex;
    @JsonProperty("@baseType")
    private String baseType;
    private String valueType;
    private String name;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
