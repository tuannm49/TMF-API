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
public class GeographicSite_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "GeographicSite_FVO_id")
    @JsonManagedReference
    private List<CalendarPeriod_FVO> calendar;
    private String code;
    @JsonProperty("@type")
    private String type;
    private String description;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "GeographicSite_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_FVO> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "GeographicSite_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "GeographicSite_FVO_id")
    @JsonManagedReference
    private List<GeographicSiteRelationship_FVO> siteRelationship;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "GeographicSite_FVO_id")
    @JsonManagedReference
    private List<PlaceRefOrValue_FVO> place;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String status;
}
