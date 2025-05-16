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
import java.util.List;
import oda.sid.vo.model.Place_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicAddress_MVO extends Place_MVO implements java.io.Serializable {
    private String country;
    private String streetType;
    @ManyToOne
    @JoinColumn(name = "geographicLocation_id")
    @JsonBackReference
    private GeographicLocationRefOrValue_MVO geographicLocation;
    private String city;
    private String streetNr;
    @OneToMany
    @JoinColumn(name = "GeographicAddress_MVO_id")
    @JsonManagedReference
    private List<GeographicAddressRelationship_MVO> geographicAddressRelationship;
    private String locality;
    private String postcode;
    private String geographicAddressType;
    private String streetNrLast;
    private String streetNrSuffix;
    private String streetName;
    @ManyToOne
    @JoinColumn(name = "geographicSite_id")
    @JsonBackReference
    private GeographicSiteRefOrValue_MVO geographicSite;
    private String stateOrProvince;
    @OneToMany
    @JoinColumn(name = "GeographicAddress_MVO_id")
    @JsonManagedReference
    private List<StandardIdentifier_MVO> countryCode;
    private String streetNrLastSuffix;
    private String streetSuffix;
    @OneToMany
    @JoinColumn(name = "GeographicAddress_MVO_id")
    @JsonManagedReference
    private List<GeographicSubAddress_MVO> geographicSubAddress;
}
