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
public class LightGeographicAddress_FVO extends Extensible implements java.io.Serializable {
    private String streetName;
    private String stateOrProvince;
    private String city;
    private String streetNr;
    @ManyToOne
    @JoinColumn(name = "countryCode_id")
    @JsonBackReference
    private ISO31661Alpha2StandardIdentifier_FVO countryCode;
    private String locality;
    private String postcode;
    @ManyToOne
    @JoinColumn(name = "geographicSubAddress_id")
    @JsonBackReference
    private LightGeographicSubAddress geographicSubAddress;
}
