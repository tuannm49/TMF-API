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
public class PartyPrivacyAgreement_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PartyPrivacyAgreement_MVO_id")
    @JsonManagedReference
    private List<PartyPrivacyProfileCharacteristic_MVO> partyPrivacyProfileCharacteristic;
    private String agreementType;
    @ManyToOne
    @JoinColumn(name = "agreementPeriod_id")
    @JsonBackReference
    private TimePeriod agreementPeriod;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "agreementSpecification_id")
    @JsonBackReference
    private AgreementSpecificationRef_MVO agreementSpecification;
    private String description;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyAgreement_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private String version;
    private OffsetDateTime initialDate;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyAgreement_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> characteristic;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyAgreement_MVO_id")
    @JsonManagedReference
    private List<AgreementRelationship_MVO> agreementRelationship;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyAgreement_MVO_id")
    @JsonManagedReference
    private List<AgreementAuthorization_MVO> agreementAuthorization;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyAgreement_MVO_id")
    @JsonManagedReference
    private List<PartyPrivacyProfileRef_MVO> partyPrivacyProfile;
    private String name;
    @ManyToOne
    @JoinColumn(name = "completionDate_id")
    @JsonBackReference
    private TimePeriod completionDate;
    private String statementOfIntent;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyAgreement_MVO_id")
    @JsonManagedReference
    private List<AgreementItem_MVO> agreementItem;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyAgreement_MVO_id")
    @JsonManagedReference
    private List<PartyRefOrPartyRoleRef_MVO> engagedParty;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyAgreement_MVO_id")
    @JsonManagedReference
    private List<RelatedDocumentRefOrValue_MVO> relatedDocument;
    private String status;
}
