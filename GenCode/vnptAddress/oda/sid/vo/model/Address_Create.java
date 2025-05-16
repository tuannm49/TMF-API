package oda.sid.vo.model;

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
public class Address_Create implements java.io.Serializable {
    private String href;
    private String city;
    private String cityId;
    private String country;
    private String countryId;
    private String locality;
    private String localityId;
    private String name;
    private String postcode;
    private String stateOrProvince;
    private String provinceId;
    private String streetName;
    private String streetId;
    private String streetNr;
    private String streetNrLast;
    private String streetNrLastSuffix;
    private String streetNrSuffix;
    private String streetSuffix;
    private String streetType;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
