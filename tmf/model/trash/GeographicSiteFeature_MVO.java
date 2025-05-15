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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicSiteFeature_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "GeographicSiteFeature_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    @OneToMany
    @JoinColumn(name = "GeographicSiteFeature_MVO_id")
    @JsonManagedReference
    private List<CalendarPeriod_MVO> validFor;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "GeographicSiteFeature_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> featureCharacteristic;
    @OneToMany
    @JoinColumn(name = "GeographicSiteFeature_MVO_id")
    @JsonManagedReference
    private List<PolicyRef_MVO> policyConstraint;
    @OneToMany
    @JoinColumn(name = "GeographicSiteFeature_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "GeographicSiteFeature_MVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_MVO> attachment;
    private Boolean isEnabled;
    private String name;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private List<String> featureCategory;
    @OneToMany
    @JoinColumn(name = "GeographicSiteFeature_MVO_id")
    @JsonManagedReference
    private List<FeatureRelationship_MVO> featureRelationship;
}
