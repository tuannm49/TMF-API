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
public class Party implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Party_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalReference;
    @OneToMany
    @JoinColumn(name = "Party_id")
    @JsonManagedReference
    private List<TaxExemptionCertificate> taxExemptionCertificate;
    @OneToMany
    @JoinColumn(name = "Party_id")
    @JsonManagedReference
    private List<Characteristic> partyCharacteristic;
    @OneToMany
    @JoinColumn(name = "Party_id")
    @JsonManagedReference
    private List<ContactMedium> contactMedium;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Party_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> relatedParty;
    @OneToMany
    @JoinColumn(name = "Party_id")
    @JsonManagedReference
    private List<PartyCreditProfile> creditRating;
}
