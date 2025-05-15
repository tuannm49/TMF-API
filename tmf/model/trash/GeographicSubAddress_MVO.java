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
public class GeographicSubAddress_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "GeographicSubAddress_MVO_id")
    @JsonManagedReference
    private List<GeographicSubAddressUnit_MVO> subUnit;
    @JsonProperty("@type")
    private String type;
    private String buildingName;
    @JsonProperty("@baseType")
    private String baseType;
    private String levelType;
    private String levelNumber;
    private String name;
    private String subAddressType;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String privateStreetNumber;
    private String privateStreetName;
}
