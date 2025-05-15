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
public class ProductOfferingQualification_Update implements java.io.Serializable {
    @JsonProperty("@type")
    private String type;
    private OffsetDateTime expectedPOQCompletionDate;
    private Boolean provideAlternative;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualification_Update_id")
    @JsonManagedReference
    private List<StateChange> stateChange;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualification_Update_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrValue> relatedParty;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualification_Update_id")
    @JsonManagedReference
    private List<ProductOfferingQualificationItem> productOfferingQualificationItem;
    private Boolean instantSyncQualification;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime effectiveQualificationDate;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String projectId;
    private OffsetDateTime requestedPOQCompletionDate;
}
