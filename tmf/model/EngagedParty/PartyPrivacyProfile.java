package com.example.EngagedParty;

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
public class PartyPrivacyProfile implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PartyPrivacyProfile_id")
    @JsonManagedReference
    private List<PartyPrivacyProfileCharacteristic> partyPrivacyProfileCharacteristic;
    @ManyToOne
    @JoinColumn(name = "agreement_id")
    @JsonBackReference
    private PartyPrivacyAgreementRef agreement;
    @ManyToOne
    @JoinColumn(name = "applicableForParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef applicableForParty;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "agreedByParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef agreedByParty;
    private String description;
    @ManyToOne
    @JoinColumn(name = "partyPrivacyProfileSpecification_id")
    @JsonBackReference
    private PartyPrivacyProfileSpecificationRef partyPrivacyProfileSpecification;
    private OffsetDateTime creationDate;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime lastUpdate;
    private String name;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String status;
}
