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
public class CheckWorkQualification implements java.io.Serializable {
    private OffsetDateTime expectedQualificationDate;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "CheckWorkQualification_id")
    @JsonManagedReference
    private List<CheckWorkQualificationItem> workQualificationItem;
    private String description;
    private String externalId;
    private Boolean provideAlternative;
    private Boolean provideUnavailabilityReason;
    @OneToMany
    @JoinColumn(name = "CheckWorkQualification_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private OffsetDateTime checkWorkQualificationDate;
    private Boolean instantSyncQualification;
    private String qualificationResult;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime effectiveQualificationDate;
    @Id
    private String id;
    private String href;
    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private PlaceRefOrValue place;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime estimatedResponseDate;
    private OffsetDateTime expirationDate;
}
