package oda.sid.tmf.model.common;

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
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicAddress implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private String city;
    private String country;
    private String locality;
    private String name;
    private String postcode;
    private String stateOrProvince;
    private String streetName;
    private String streetNr;
    private String streetNrLast;
    private String streetNrLastSuffix;
    private String streetNrSuffix;
    private String streetSuffix;
    private String streetType;
    @ManyToOne
    @JoinColumn(name = "geographicLocation_id")
    @JsonBackReference
    private GeographicLocationRefOrValue geographicLocation;
    @OneToMany
    @JoinColumn(name = "GeographicAddress_id")
    @JsonManagedReference
    private List<GeographicSubAddress> geographicSubAddress;
}
