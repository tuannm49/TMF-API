package com.example.trash;

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
public class CheckWorkQualification_Create implements java.io.Serializable {
    private OffsetDateTime expectedQualificationDate;
    private Boolean instantSyncQualification;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "CheckWorkQualification_Create_id")
    @JsonManagedReference
    private List<CheckWorkQualificationItem> workQualificationItem;
    private String description;
    private String externalId;
    private Boolean provideAlternative;
    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private PlaceRefOrValue place;
    private Boolean provideUnavailabilityReason;
    @OneToMany
    @JoinColumn(name = "CheckWorkQualification_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
