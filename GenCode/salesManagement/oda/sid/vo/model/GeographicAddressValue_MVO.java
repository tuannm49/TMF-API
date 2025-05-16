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
import oda.sid.vo.model.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicAddressValue_MVO extends Extensible implements java.io.Serializable {
    private String country;
    private String streetType;
    private String city;
    private String streetNr;
    private String locality;
    private String postcode;
    private String streetNrLast;
    private String streetNrSuffix;
    private String streetName;
    private String stateOrProvince;
    private String streetNrLastSuffix;
    private String streetSuffix;
    @ManyToOne
    @JoinColumn(name = "geographicSubAddress_id")
    @JsonBackReference
    private GeographicSubAddressValue_MVO geographicSubAddress;
}
