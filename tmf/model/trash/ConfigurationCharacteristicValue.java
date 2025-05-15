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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigurationCharacteristicValue implements java.io.Serializable {
    private String rangeInterval;
    private String regex;
    private Integer valueTo;
    @JsonProperty("@baseType")
    private String baseType;
    private String unitOfMeasure;
    @JsonProperty("@type")
    private String type;
    private Boolean isSelected;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private Boolean isSelectable;
    @ManyToOne
    @JoinColumn(name = "characteristicValue_id")
    @JsonBackReference
    private Characteristic characteristicValue;
    private Integer valueFrom;
}
