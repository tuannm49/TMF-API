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
public class PartyPrivacyProfile_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PartyPrivacyProfile_MVO_id")
    @JsonManagedReference
    private List<PartyPrivacyProfileCharacteristic_MVO> partyPrivacyProfileCharacteristic;
    @ManyToOne
    @JoinColumn(name = "agreement_id")
    @JsonBackReference
    private PartyPrivacyAgreementRef_MVO agreement;
    @ManyToOne
    @JoinColumn(name = "applicableForParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_MVO applicableForParty;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "agreedByParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_MVO agreedByParty;
    private String description;
    @ManyToOne
    @JoinColumn(name = "partyPrivacyProfileSpecification_id")
    @JsonBackReference
    private PartyPrivacyProfileSpecificationRef_MVO partyPrivacyProfileSpecification;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime lastUpdate;
    private String name;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String status;
}
