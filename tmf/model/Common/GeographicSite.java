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
public class GeographicSite implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "GeographicSite_id")
    @JsonManagedReference
    private List<CalendarPeriod> calendar;
    private String code;
    @JsonProperty("@type")
    private String type;
    private String description;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "GeographicSite_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "GeographicSite_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "GeographicSite_id")
    @JsonManagedReference
    private List<GeographicSiteRelationship> siteRelationship;
    private String href;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "GeographicSite_id")
    @JsonManagedReference
    private List<PlaceRefOrValue> place;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String status;
}
