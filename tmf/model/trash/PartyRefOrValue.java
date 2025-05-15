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
public class PartyRefOrValue implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PartyRefOrValue_id")
    @JsonManagedReference
    private List<TaxExemptionCertificate> taxExemptionCertificate;
    @OneToMany
    @JoinColumn(name = "PartyRefOrValue_id")
    @JsonManagedReference
    private List<Characteristic> partyCharacteristic;
    @OneToMany
    @JoinColumn(name = "PartyRefOrValue_id")
    @JsonManagedReference
    private List<ContactMedium> contactMedium;
    @JsonProperty("@referredType")
    private String referredType;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "PartyRefOrValue_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @OneToMany
    @JoinColumn(name = "PartyRefOrValue_id")
    @JsonManagedReference
    private List<ExternalReference> externalReference;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    @Id
    private String id;
    private String href;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "PartyRefOrValue_id")
    @JsonManagedReference
    private List<PartyCreditProfile> creditRating;
}
