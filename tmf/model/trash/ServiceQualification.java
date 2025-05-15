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
public class ServiceQualification implements java.io.Serializable {
    private OffsetDateTime expectedQualificationDate;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ServiceQualification_id")
    @JsonManagedReference
    private List<ErrorMessage> errorMessage;
    private String description;
    @OneToMany
    @JoinColumn(name = "ServiceQualification_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    private Boolean instantSyncQualification;
    private OffsetDateTime effectiveQualificationDate;
    @OneToMany
    @JoinColumn(name = "ServiceQualification_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    private String href;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime estimatedResponseDate;
    private OffsetDateTime expirationDate;
}
