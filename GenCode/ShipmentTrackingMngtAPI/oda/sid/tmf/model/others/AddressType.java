package oda.sid.tmf.model.others;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressType implements java.io.Serializable {
    private String streetNr;
    private String streetNrSuffix;
    private String streetNrLast;
    private String streetNrLastSuffix;
    private String streetName;
    private String streetType;
    private String streetSuffix;
    private String postcode;
    private String locality;
    private String city;
    private String stateOrProvince;
    private String country;
    @JsonProperty("@type")
    private String type;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "geographicLocation_id")
    @JsonBackReference
    private GeographicLocationType geographicLocation;
    @ManyToOne
    @JoinColumn(name = "geographicSubAddress_id")
    @JsonBackReference
    private SubAddressType geographicSubAddress;
}
