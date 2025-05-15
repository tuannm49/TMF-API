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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Organization implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Organization_id")
    @JsonManagedReference
    private List<TaxExemptionCertificate> taxExemptionCertificate;
    private String tradingName;
    @OneToMany
    @JoinColumn(name = "Organization_id")
    @JsonManagedReference
    private List<Characteristic> partyCharacteristic;
    @OneToMany
    @JoinColumn(name = "Organization_id")
    @JsonManagedReference
    private List<ContactMedium> contactMedium;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "Organization_id")
    @JsonManagedReference
    private List<OrganizationChildRelationship> organizationChildRelationship;
    @OneToMany
    @JoinColumn(name = "Organization_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> relatedParty;
    @OneToMany
    @JoinColumn(name = "Organization_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalReference;
    private String organizationType;
    private String nameType;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "existsDuring_id")
    @JsonBackReference
    private TimePeriod existsDuring;
    private Boolean isHeadOffice;
    private String name;
    private Boolean isLegalEntity;
    @OneToMany
    @JoinColumn(name = "Organization_id")
    @JsonManagedReference
    private List<OtherNameOrganization> otherName;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Organization_id")
    @JsonManagedReference
    private List<OrganizationIdentification> organizationIdentification;
    @OneToMany
    @JoinColumn(name = "Organization_id")
    @JsonManagedReference
    private List<PartyCreditProfile> creditRating;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private OrganizationStateType status;
    @ManyToOne
    @JoinColumn(name = "organizationParentRelationship_id")
    @JsonBackReference
    private OrganizationParentRelationship organizationParentRelationship;
}
