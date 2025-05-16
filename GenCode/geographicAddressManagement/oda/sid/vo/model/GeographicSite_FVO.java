package oda.sid.vo.model;

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
import oda.sid.vo.model.Place_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicSite_FVO extends Place_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "GeographicSite_FVO_id")
    @JsonManagedReference
    private List<CalendarPeriod_FVO> calendar;
    @OneToMany
    @JoinColumn(name = "GeographicSite_FVO_id")
    @JsonManagedReference
    private List<GeographicSiteFeature_FVO> siteFeature;
    @OneToMany
    @JoinColumn(name = "GeographicSite_FVO_id")
    @JsonManagedReference
    private List<ContactMedium> contactMedium;
    private String code;
    private String description;
    @OneToMany
    @JoinColumn(name = "GeographicSite_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "GeographicSite_FVO_id")
    @JsonManagedReference
    private List<GeographicSiteRelationship_FVO> siteRelationship;
    @OneToMany
    @JoinColumn(name = "GeographicSite_FVO_id")
    @JsonManagedReference
    private List<PlaceRefOrValue_FVO> place;
    private String siteCategory;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "GeographicSite_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    private String status;
}
