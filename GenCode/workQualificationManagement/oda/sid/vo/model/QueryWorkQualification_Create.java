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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryWorkQualification_Create implements java.io.Serializable {
    private String description;
    private OffsetDateTime expectedQualificationDate;
    private String externalId;
    private Boolean instantSyncQualification;
    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private PlaceRefOrValue place;
    @OneToMany
    @JoinColumn(name = "QueryWorkQualification_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "searchCriteria_id")
    @JsonBackReference
    private WorkQualificationItem searchCriteria;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
