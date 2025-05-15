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
public class GeographicAddressValue_FVO implements java.io.Serializable {
    private String country;
    private String streetType;
    private String city;
    @JsonProperty("@type")
    private String type;
    private String streetNr;
    private String locality;
    private String postcode;
    private String streetNrLast;
    private String streetNrSuffix;
    private String streetName;
    @JsonProperty("@baseType")
    private String baseType;
    private String stateOrProvince;
    private String streetNrLastSuffix;
    private String streetSuffix;
    @ManyToOne
    @JoinColumn(name = "geographicSubAddress_id")
    @JsonBackReference
    private GeographicSubAddressValue_FVO geographicSubAddress;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
