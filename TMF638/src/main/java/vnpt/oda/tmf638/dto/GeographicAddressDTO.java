package vnpt.oda.tmf638.dto;


import lombok.Data;

@Data
public class GeographicAddressDTO {
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
