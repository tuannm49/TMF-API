package com.example.Common;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicAddressValidation implements java.io.Serializable {
    private String validationResult;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "GeographicAddressValidation_id")
    @JsonManagedReference
    private List<AlternateGeographicAddressValidation> alternateGeographicAddress;
    @ManyToOne
    @JoinColumn(name = "validGeographicAddress_id")
    @JsonBackReference
    private GeographicAddress validGeographicAddress;
    private Boolean provideAlternative;
    @ManyToOne
    @JoinColumn(name = "submittedGeographicAddress_id")
    @JsonBackReference
    private GeographicAddress submittedGeographicAddress;
    private String href;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    private OffsetDateTime validationDate;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
