package oda.sid.tmf.model.others;

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
public class CheckWorkQualification implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private OffsetDateTime checkWorkQualificationDate;
    private String description;
    private OffsetDateTime effectiveQualificationDate;
    private OffsetDateTime estimatedResponseDate;
    private OffsetDateTime expectedQualificationDate;
    private OffsetDateTime expirationDate;
    private String externalId;
    private Boolean instantSyncQualification;
    private Boolean provideAlternative;
    private Boolean provideUnavailabilityReason;
    private String qualificationResult;
    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonBackReference
    private PlaceRefOrValue place;
    @OneToMany
    @JoinColumn(name = "CheckWorkQualification_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @OneToMany
    @JoinColumn(name = "CheckWorkQualification_id")
    @JsonManagedReference
    private List<CheckWorkQualificationItem> workQualificationItem;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
