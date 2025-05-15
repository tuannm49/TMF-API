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
public class GeographicSubAddress implements java.io.Serializable {
    private String buildingName;
    private String subUnitNumber;
    private String levelType;
    private String subUnitType;
    private String levelNumber;
    private String name;
    private String subAddressType;
    @Id
    private String id;
    private String href;
    private String privateStreetNumber;
    private String privateStreetName;
}
