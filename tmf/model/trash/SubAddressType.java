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
public class SubAddressType implements java.io.Serializable {
    private String subUnitNumber;
    @JsonProperty("@type")
    private String type;
    private String type;
    private String buildingName;
    private String subUnitType;
    private String levelType;
    private String name;
    private String levelNumber;
    @Id
    private String id;
    private String href;
    private String privateStreetNumber;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String privateStreetName;
}
