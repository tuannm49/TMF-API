package vnpt.oda.tmf638.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "geographic_address")
public class GeographicAddress {
    @Id
    private String id;

    private String city;
    private String country;
    private String countryCode;
    private String geographicAddressType;
    private String locality;
    private String postcode;
    private String stateOrProvince;
    private String streetName;
    private String streetNr;
    private String streetNrLast;
    private String streetNrLastSuffix;
    private String streetNrSuffix;
    private String streetSuffix;
    private String streetType;
    private String href;
    private String baseType;
    private String schemaLocation;
    private String type;
}

