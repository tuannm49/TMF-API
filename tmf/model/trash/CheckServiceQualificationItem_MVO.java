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
public class CheckServiceQualificationItem_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CheckServiceQualificationItem_MVO_id")
    @JsonManagedReference
    private List<ServiceQualificationItemRelationship> qualificationItemRelationship;
    @OneToMany
    @JoinColumn(name = "CheckServiceQualificationItem_MVO_id")
    @JsonManagedReference
    private List<AlternateServiceProposal_MVO> alternateServiceProposal;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "CheckServiceQualificationItem_MVO_id")
    @JsonManagedReference
    private List<TerminationError> terminationError;
    @JsonProperty("@baseType")
    private String baseType;
    private String qualificationResult;
    private OffsetDateTime expectedServiceAvailabilityDate;
    @ManyToOne
    @JoinColumn(name = "service_id")
    @JsonBackReference
    private ServiceRefOrValue_MVO service;
    @OneToMany
    @JoinColumn(name = "CheckServiceQualificationItem_MVO_id")
    @JsonManagedReference
    private List<ServiceQualificationRelationship> qualificationRelationship;
    @OneToMany
    @JoinColumn(name = "CheckServiceQualificationItem_MVO_id")
    @JsonManagedReference
    private List<EligibilityResultReason_MVO> eligibilityResultReason;
    @Id
    private String id;
    private String state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime expectedActivationDate;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private ServiceCategoryRef_MVO category;
    private OffsetDateTime expirationDate;
}
