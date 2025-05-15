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
public class Address_Create implements java.io.Serializable {
    private String country;
    private String streetType;
    private String city;
    private String streetNr;
    @JsonProperty("@type")
    private String type;
    private String locality;
    private String postcode;
    private String cityId;
    private String provinceId;
    private String streetNrLast;
    private String countryId;
    private String streetNrSuffix;
    private String streetName;
    private String stateOrProvince;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    private String streetNrLastSuffix;
    private String streetSuffix;
    private String href;
    private String localityId;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String streetId;
}
