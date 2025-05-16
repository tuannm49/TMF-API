package oda.sid.tmf.model.product;

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
public class ProductOfferingQualificationItem implements java.io.Serializable {
    @Id
    private String id;
    private OffsetDateTime expectedActivationDate;
    private OffsetDateTime guaranteedUntilDate;
    private String serviceConfidenceReason;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private ProductActionType action;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualificationItem_id")
    @JsonManagedReference
    private List<AlternateProductOfferingProposal> alternateProductOfferingProposal;
    @ManyToOne
    @JoinColumn(name = "installationInterval_id")
    @JsonBackReference
    private TimePeriod installationInterval;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue product;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef productOffering;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualificationItem_id")
    @JsonManagedReference
    private List<QualificationItemRelationship> qualificationItemRelationship;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualificationItem_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrValue> relatedParty;
    @ManyToOne
    @JoinColumn(name = "serviceabilityConfidence_id")
    @JsonBackReference
    private ServiceabilityColor serviceabilityConfidence;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualificationItem_id")
    @JsonManagedReference
    private List<TerminationError> terminationError;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
