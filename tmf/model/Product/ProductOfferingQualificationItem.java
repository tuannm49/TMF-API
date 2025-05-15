package com.example.Product;

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
public class ProductOfferingQualificationItem implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue product;
    @ManyToOne
    @JoinColumn(name = "serviceabilityConfidence_id")
    @JsonBackReference
    private ServiceabilityColor serviceabilityConfidence;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualificationItem_id")
    @JsonManagedReference
    private List<QualificationItemRelationship> qualificationItemRelationship;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualificationItem_id")
    @JsonManagedReference
    private List<AlternateProductOfferingProposal> alternateProductOfferingProposal;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef productOffering;
    @JsonProperty("@type")
    private String type;
    private String serviceConfidenceReason;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualificationItem_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrValue> relatedParty;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualificationItem_id")
    @JsonManagedReference
    private List<TerminationError> terminationError;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "installationInterval_id")
    @JsonBackReference
    private TimePeriod installationInterval;
    private OffsetDateTime guaranteedUntilDate;
    @ManyToOne
    @JoinColumn(name = "action_id")
    @JsonBackReference
    private ProductActionType action;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    private OffsetDateTime expectedActivationDate;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
