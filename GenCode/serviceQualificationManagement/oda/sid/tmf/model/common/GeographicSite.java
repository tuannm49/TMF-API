package oda.sid.tmf.model.common;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.tmf.model.common.Place;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicSite extends Place implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "GeographicSite_id")
    @JsonManagedReference
    private List<CalendarPeriod> calendar;
    private String code;
    private String description;
    @OneToMany
    @JoinColumn(name = "GeographicSite_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "GeographicSite_id")
    @JsonManagedReference
    private List<GeographicSiteRelationship> siteRelationship;
    @OneToMany
    @JoinColumn(name = "GeographicSite_id")
    @JsonManagedReference
    private List<PlaceRefOrValue> place;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "GeographicSite_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    private String status;
}
