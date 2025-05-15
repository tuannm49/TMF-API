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
public class GeographicAddressContactMedium_MVO implements java.io.Serializable {
    private String country;
    private String stateOrProvince;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String city;
    private String contactType;
    private String postCode;
    private String street1;
    private String street2;
    @ManyToOne
    @JoinColumn(name = "geographicAddress_id")
    @JsonBackReference
    private GeographicAddressRef_MVO geographicAddress;
    private Boolean preferred;
}
