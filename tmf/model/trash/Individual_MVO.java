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
public class Individual_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Individual_MVO_id")
    @JsonManagedReference
    private List<TaxExemptionCertificate_MVO> taxExemptionCertificate;
    @OneToMany
    @JoinColumn(name = "Individual_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> partyCharacteristic;
    @OneToMany
    @JoinColumn(name = "Individual_MVO_id")
    @JsonManagedReference
    private List<ContactMedium_MVO> contactMedium;
    private String gender;
    private String aristocraticTitle;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "Individual_MVO_id")
    @JsonManagedReference
    private List<Disability> disability;
    private String formattedName;
    @OneToMany
    @JoinColumn(name = "Individual_MVO_id")
    @JsonManagedReference
    private List<IndividualIdentification_MVO> individualIdentification;
    private String title;
    private String legalName;
    @JsonProperty("@baseType")
    private String baseType;
    private String countryOfBirth;
    @OneToMany
    @JoinColumn(name = "Individual_MVO_id")
    @JsonManagedReference
    private List<Skill> skill;
    private String familyName;
    private OffsetDateTime deathDate;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Individual_MVO_id")
    @JsonManagedReference
    private List<PartyCreditProfile_MVO> creditRating;
    private String generation;
    private String placeOfBirth;
    private String givenName;
    @OneToMany
    @JoinColumn(name = "Individual_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> relatedParty;
    private OffsetDateTime birthDate;
    @OneToMany
    @JoinColumn(name = "Individual_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalReference;
    @OneToMany
    @JoinColumn(name = "Individual_MVO_id")
    @JsonManagedReference
    private List<LanguageAbility> languageAbility;
    private String nationality;
    private String preferredGivenName;
    private String familyNamePrefix;
    private String name;
    private String middleName;
    private String location;
    @OneToMany
    @JoinColumn(name = "Individual_MVO_id")
    @JsonManagedReference
    private List<OtherNameIndividual> otherName;
    private String maritalStatus;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private IndividualStateType status;
}
