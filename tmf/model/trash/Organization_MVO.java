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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Organization_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Organization_MVO_id")
    @JsonManagedReference
    private List<TaxExemptionCertificate_MVO> taxExemptionCertificate;
    private String tradingName;
    @OneToMany
    @JoinColumn(name = "Organization_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> partyCharacteristic;
    @OneToMany
    @JoinColumn(name = "Organization_MVO_id")
    @JsonManagedReference
    private List<ContactMedium_MVO> contactMedium;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "Organization_MVO_id")
    @JsonManagedReference
    private List<OrganizationChildRelationship_MVO> organizationChildRelationship;
    @OneToMany
    @JoinColumn(name = "Organization_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "Organization_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalReference;
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
    @JoinColumn(name = "Organization_MVO_id")
    @JsonManagedReference
    private List<OtherNameOrganization_MVO> otherName;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Organization_MVO_id")
    @JsonManagedReference
    private List<OrganizationIdentification_MVO> organizationIdentification;
    @OneToMany
    @JoinColumn(name = "Organization_MVO_id")
    @JsonManagedReference
    private List<PartyCreditProfile_MVO> creditRating;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private OrganizationStateType status;
    @ManyToOne
    @JoinColumn(name = "organizationParentRelationship_id")
    @JsonBackReference
    private OrganizationParentRelationship_MVO organizationParentRelationship;
}
