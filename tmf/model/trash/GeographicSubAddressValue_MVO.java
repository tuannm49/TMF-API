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
public class GeographicSubAddressValue_MVO implements java.io.Serializable {
    private String buildingName;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "GeographicSubAddressValue_MVO_id")
    @JsonManagedReference
    private List<GeographicSubAddressUnit_MVO> subUnit;
    @JsonProperty("@type")
    private String type;
    private String levelType;
    private String levelNumber;
    private String name;
    private String subAddressType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String privateStreetNumber;
    private String privateStreetName;
}
