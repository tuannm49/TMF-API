package com.example.Common;

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
public class GeographicAddress implements java.io.Serializable {
    private String country;
    private String streetType;
    @ManyToOne
    @JoinColumn(name = "geographicLocation_id")
    @JsonBackReference
    private GeographicLocationRefOrValue geographicLocation;
    private String city;
    @JsonProperty("@type")
    private String type;
    private String streetNr;
    private String locality;
    private String postcode;
    private String geographicAddressType;
    private String streetNrLast;
    private String streetNrSuffix;
    private String streetName;
    @JsonProperty("@baseType")
    private String baseType;
    private String stateOrProvince;
    @OneToMany
    @JoinColumn(name = "GeographicAddress_id")
    @JsonManagedReference
    private List<StandardIdentifier> countryCode;
    private String streetNrLastSuffix;
    @OneToMany
    @JoinColumn(name = "GeographicAddress_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    private String streetSuffix;
    @OneToMany
    @JoinColumn(name = "GeographicAddress_id")
    @JsonManagedReference
    private List<GeographicSubAddress> geographicSubAddress;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
