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
public class BusinessPartner_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "BusinessPartner_FVO_id")
    @JsonManagedReference
    private List<ContactMedium_FVO> contactMedium;
    @OneToMany
    @JoinColumn(name = "BusinessPartner_FVO_id")
    @JsonManagedReference
    private List<CreditProfile_FVO> creditProfile;
    private String role;
    @OneToMany
    @JoinColumn(name = "BusinessPartner_FVO_id")
    @JsonManagedReference
    private List<AgreementRef_FVO> agreement;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String description;
    @OneToMany
    @JoinColumn(name = "BusinessPartner_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_FVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "BusinessPartner_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> characteristic;
    private String statusReason;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "partyRoleSpecification_id")
    @JsonBackReference
    private PartyRoleSpecificationRef_FVO partyRoleSpecification;
    private String name;
    @OneToMany
    @JoinColumn(name = "BusinessPartner_FVO_id")
    @JsonManagedReference
    private List<PaymentMethodRef_FVO> paymentMethod;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "engagedParty_id")
    @JsonBackReference
    private PartyRef_FVO engagedParty;
    @OneToMany
    @JoinColumn(name = "BusinessPartner_FVO_id")
    @JsonManagedReference
    private List<AccountRef_FVO> account;
    private String status;
}
