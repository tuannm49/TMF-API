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
public class MediumCharacteristic implements java.io.Serializable {
    private String country;
    private String city;
    @JsonProperty("@type")
    private String type;
    private String contactType;
    private String socialNetworkId;
    private String emailAddress;
    private String phoneNumber;
    private String stateOrProvince;
    @JsonProperty("@baseType")
    private String baseType;
    private String faxNumber;
    private String postCode;
    private String street1;
    @Id
    private String id;
    private String href;
    private String street2;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
