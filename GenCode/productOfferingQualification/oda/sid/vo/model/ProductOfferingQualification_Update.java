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
public class ProductOfferingQualification_Update implements java.io.Serializable {
    private OffsetDateTime effectiveQualificationDate;
    private OffsetDateTime expectedPOQCompletionDate;
    private Boolean instantSyncQualification;
    private String projectId;
    private Boolean provideAlternative;
    private OffsetDateTime requestedPOQCompletionDate;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualification_Update_id")
    @JsonManagedReference
    private List<ProductOfferingQualificationItem> productOfferingQualificationItem;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualification_Update_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrValue> relatedParty;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualification_Update_id")
    @JsonManagedReference
    private List<StateChange> stateChange;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
