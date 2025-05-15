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
public class AlternateGeographicAddressValidation_FVO implements java.io.Serializable {
    private String country;
    @ManyToOne
    @JoinColumn(name = "geographicLocation_id")
    @JsonBackReference
    private GeographicLocationRefOrValue_FVO geographicLocation;
    private String city;
    @JsonProperty("@type")
    private String type;
    private String streetNrLast;
    private Object similarityScore;
    private String streetName;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "AlternateGeographicAddressValidation_FVO_id")
    @JsonManagedReference
    private List<StandardIdentifier> countryCode;
    private String streetNrLastSuffix;
    @OneToMany
    @JoinColumn(name = "AlternateGeographicAddressValidation_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "AlternateGeographicAddressValidation_FVO_id")
    @JsonManagedReference
    private List<GeographicSubAddress_FVO> geographicSubAddress;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String streetType;
    private String streetNr;
    @OneToMany
    @JoinColumn(name = "AlternateGeographicAddressValidation_FVO_id")
    @JsonManagedReference
    private List<GeographicAddressRelationship_FVO> geographicAddressRelationship;
    private String locality;
    private String postcode;
    private String geographicAddressType;
    private String streetNrSuffix;
    private String matchingDegree;
    private String matchinRule;
    @ManyToOne
    @JoinColumn(name = "geographicSite_id")
    @JsonBackReference
    private GeographicSiteRefOrValue_FVO geographicSite;
    private String stateOrProvince;
    private String streetSuffix;
}
