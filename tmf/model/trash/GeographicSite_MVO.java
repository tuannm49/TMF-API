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
public class GeographicSite_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "GeographicSite_MVO_id")
    @JsonManagedReference
    private List<CalendarPeriod_MVO> calendar;
    private String code;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    private String description;
    @OneToMany
    @JoinColumn(name = "GeographicSite_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "GeographicSite_MVO_id")
    @JsonManagedReference
    private List<GeographicSiteRelationship_MVO> siteRelationship;
    @OneToMany
    @JoinColumn(name = "GeographicSite_MVO_id")
    @JsonManagedReference
    private List<PlaceRefOrValue_MVO> place;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "GeographicSite_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> relatedParty;
    private String status;
}
