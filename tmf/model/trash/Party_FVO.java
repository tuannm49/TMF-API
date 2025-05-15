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
public class Party_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Party_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalReference;
    @OneToMany
    @JoinColumn(name = "Party_FVO_id")
    @JsonManagedReference
    private List<TaxExemptionCertificate_FVO> taxExemptionCertificate;
    @OneToMany
    @JoinColumn(name = "Party_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> partyCharacteristic;
    @OneToMany
    @JoinColumn(name = "Party_FVO_id")
    @JsonManagedReference
    private List<ContactMedium_FVO> contactMedium;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Party_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_FVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "Party_FVO_id")
    @JsonManagedReference
    private List<PartyCreditProfile_FVO> creditRating;
}
