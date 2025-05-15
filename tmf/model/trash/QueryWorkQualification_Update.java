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
public class QueryWorkQualification_Update implements java.io.Serializable {
    private OffsetDateTime expectedQualificationDate;
    @ManyToOne
    @JoinColumn(name = "searchCriteria_id")
    @JsonBackReference
    private WorkQualificationItem searchCriteria;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "QueryWorkQualification_Update_id")
    @JsonManagedReference
    private List<WorkQualificationItem> workQualificationItem;
    private String description;
    private String externalId;
    @OneToMany
    @JoinColumn(name = "QueryWorkQualification_Update_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private Boolean instantSyncQualification;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime effectiveQualificationDate;
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
