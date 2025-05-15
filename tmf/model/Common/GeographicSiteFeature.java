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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicSiteFeature implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "GeographicSiteFeature_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "GeographicSiteFeature_id")
    @JsonManagedReference
    private List<CalendarPeriod> validFor;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "GeographicSiteFeature_id")
    @JsonManagedReference
    private List<Characteristic> featureCharacteristic;
    @OneToMany
    @JoinColumn(name = "GeographicSiteFeature_id")
    @JsonManagedReference
    private List<PolicyRef> policyConstraint;
    @OneToMany
    @JoinColumn(name = "GeographicSiteFeature_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "GeographicSiteFeature_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    private Boolean isEnabled;
    private String name;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private List<String> featureCategory;
    @OneToMany
    @JoinColumn(name = "GeographicSiteFeature_id")
    @JsonManagedReference
    private List<FeatureRelationship> featureRelationship;
}
