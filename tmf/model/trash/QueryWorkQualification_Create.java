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
public class QueryWorkQualification_Create implements java.io.Serializable {
    private OffsetDateTime expectedQualificationDate;
    private Boolean instantSyncQualification;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "searchCriteria_id")
    @JsonBackReference
    private WorkQualificationItem searchCriteria;
    @JsonProperty("@type")
    private String type;
    private String description;
    private String externalId;
    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private PlaceRefOrValue place;
    @OneToMany
    @JoinColumn(name = "QueryWorkQualification_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
