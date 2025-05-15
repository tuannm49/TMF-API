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
public class PartyPrivacyProfileSpecification_MVO implements java.io.Serializable {
    private String lifecycleStatus;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyProfileSpecification_MVO_id")
    @JsonManagedReference
    private List<ProductOfferingRef_MVO> productOffering;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String description;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyProfileSpecification_MVO_id")
    @JsonManagedReference
    private List<PartyPrivacyRoleSpecification_MVO> applicableRole;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyProfileSpecification_MVO_id")
    @JsonManagedReference
    private List<PartyPrivacyProfileSpecificationCharacteristic_MVO> specCharacteristic;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyProfileSpecification_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private String version;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime lastUpdate;
    private String name;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
