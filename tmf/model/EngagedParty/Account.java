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
public class Account implements java.io.Serializable {
    @JsonProperty("@type")
    private String type;
    private String accountType;
    private String description;
    @OneToMany
    @JoinColumn(name = "Account_id")
    @JsonManagedReference
    private List<AccountRelationship> accountRelationship;
    @OneToMany
    @JoinColumn(name = "Account_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "Account_id")
    @JsonManagedReference
    private List<TaxExemptionCertificate> taxExemption;
    private OffsetDateTime lastUpdate;
    @OneToMany
    @JoinColumn(name = "Account_id")
    @JsonManagedReference
    private List<Contact> contact;
    private String name;
    @ManyToOne
    @JoinColumn(name = "creditLimit_id")
    @JsonBackReference
    private Money creditLimit;
    private String href;
    @Id
    private String id;
    private String state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Account_id")
    @JsonManagedReference
    private List<AccountBalance> accountBalance;
}
