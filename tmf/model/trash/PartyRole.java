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
public class PartyRole implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PartyRole_id")
    @JsonManagedReference
    private List<ContactMedium> contactMedium;
    @OneToMany
    @JoinColumn(name = "PartyRole_id")
    @JsonManagedReference
    private List<CreditProfile> creditProfile;
    private String role;
    @OneToMany
    @JoinColumn(name = "PartyRole_id")
    @JsonManagedReference
    private List<AgreementRef> agreement;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String description;
    @OneToMany
    @JoinColumn(name = "PartyRole_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> relatedParty;
    @OneToMany
    @JoinColumn(name = "PartyRole_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    private String statusReason;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "partyRoleSpecification_id")
    @JsonBackReference
    private PartyRoleSpecificationRef partyRoleSpecification;
    private String name;
    @OneToMany
    @JoinColumn(name = "PartyRole_id")
    @JsonManagedReference
    private List<PaymentMethodRef> paymentMethod;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "engagedParty_id")
    @JsonBackReference
    private PartyRef engagedParty;
    @OneToMany
    @JoinColumn(name = "PartyRole_id")
    @JsonManagedReference
    private List<AccountRef> account;
    private String status;
}
