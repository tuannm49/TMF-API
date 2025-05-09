package vnpt.oda.tmf638.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "geographic_address")
public class GeographicAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "geographic_address_type")
    private String geographicAddressType;

    @Column(name = "locality")
    private String locality;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "state_or_province")
    private String stateOrProvince;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "street_nr")
    private String streetNr;

    @Column(name = "street_nr_last")
    private String streetNrLast;

    @Column(name = "street_nr_last_suffix")
    private String streetNrLastSuffix;

    @Column(name = "street_nr_suffix")
    private String streetNrSuffix;

    @Column(name = "street_suffix")
    private String streetSuffix;

    @Column(name = "street_type")
    private String streetType;

    @Column(name = "href")
    private String href;

    @Column(name = "base_type")
    private String baseType;

    @Column(name = "schema_location")
    private String schemaLocation;

    @Column(name = "type")
    private String type;
}
