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
public class QueryServiceQualification_MVO implements java.io.Serializable {
    private OffsetDateTime expectedQualificationDate;
    @ManyToOne
    @JoinColumn(name = "searchCriteria_id")
    @JsonBackReference
    private ServiceQualificationItem_MVO searchCriteria;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "QueryServiceQualification_MVO_id")
    @JsonManagedReference
    private List<ErrorMessage_MVO> errorMessage;
    private String description;
    @OneToMany
    @JoinColumn(name = "QueryServiceQualification_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "QueryServiceQualification_MVO_id")
    @JsonManagedReference
    private List<ServiceQualificationItem_MVO> serviceQualificationItem;
    @JsonProperty("@baseType")
    private String baseType;
    private Boolean instantSyncQualification;
    private OffsetDateTime effectiveQualificationDate;
    @OneToMany
    @JoinColumn(name = "QueryServiceQualification_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime estimatedResponseDate;
    private OffsetDateTime expirationDate;
}
