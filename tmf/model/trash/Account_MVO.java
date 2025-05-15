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
public class Account_MVO implements java.io.Serializable {
    @JsonProperty("@type")
    private String type;
    private String accountType;
    private String description;
    @OneToMany
    @JoinColumn(name = "Account_MVO_id")
    @JsonManagedReference
    private List<AccountRelationship_MVO> accountRelationship;
    @OneToMany
    @JoinColumn(name = "Account_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "Account_MVO_id")
    @JsonManagedReference
    private List<TaxExemptionCertificate_MVO> taxExemption;
    private OffsetDateTime lastUpdate;
    @OneToMany
    @JoinColumn(name = "Account_MVO_id")
    @JsonManagedReference
    private List<Contact_MVO> contact;
    private String name;
    @ManyToOne
    @JoinColumn(name = "creditLimit_id")
    @JsonBackReference
    private Money creditLimit;
    private String state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Account_MVO_id")
    @JsonManagedReference
    private List<AccountBalance_MVO> accountBalance;
}
