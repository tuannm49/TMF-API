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
public class CheckServiceQualificationItem_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CheckServiceQualificationItem_FVO_id")
    @JsonManagedReference
    private List<ServiceQualificationItemRelationship> qualificationItemRelationship;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "CheckServiceQualificationItem_FVO_id")
    @JsonManagedReference
    private List<TerminationError> terminationError;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime expectedServiceAvailabilityDate;
    @ManyToOne
    @JoinColumn(name = "service_id")
    @JsonBackReference
    private ServiceRefOrValue_FVO service;
    @OneToMany
    @JoinColumn(name = "CheckServiceQualificationItem_FVO_id")
    @JsonManagedReference
    private List<ServiceQualificationRelationship> qualificationRelationship;
    @OneToMany
    @JoinColumn(name = "CheckServiceQualificationItem_FVO_id")
    @JsonManagedReference
    private List<EligibilityResultReason_FVO> eligibilityResultReason;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime expectedActivationDate;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private ServiceCategoryRef_FVO category;
    private OffsetDateTime expirationDate;
}
