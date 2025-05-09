package vnpt.oda.tmf638.dto;


import lombok.Data;

@Data
public class RelatedPlaceDTO {
    private String id;
    private String placeId;
    private String role;
    private String placeType;
    private String baseType;
    private String schemaLocation;
    private String type;
}
