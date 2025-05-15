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
public class CheckWorkQualificationItem implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CheckWorkQualificationItem_id")
    @JsonManagedReference
    private List<WorkQualificationItemRelationship> qualificationItemRelationship;
    @ManyToOne
    @JoinColumn(name = "work_id")
    @JsonBackReference
    private WorkRefOrValue work;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "CheckWorkQualificationItem_id")
    @JsonManagedReference
    private List<TerminationError> terminationError;
    @OneToMany
    @JoinColumn(name = "CheckWorkQualificationItem_id")
    @JsonManagedReference
    private List<EligibilityUnavailabilityReason> eligibilityUnavailabilityReason;
    private String qualificationResult;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "CheckWorkQualificationItem_id")
    @JsonManagedReference
    private List<AlternateWorkProposal> alternateWorkProposal;
    private OffsetDateTime expectedWorkDate;
    @OneToMany
    @JoinColumn(name = "CheckWorkQualificationItem_id")
    @JsonManagedReference
    private List<WorkQualificationRelationship> qualificationRelationship;
    @Id
    private String id;
    private String state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime expirationDate;
}
