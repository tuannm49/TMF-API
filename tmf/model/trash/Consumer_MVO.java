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
public class Consumer_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Consumer_MVO_id")
    @JsonManagedReference
    private List<ContactMedium_MVO> contactMedium;
    @OneToMany
    @JoinColumn(name = "Consumer_MVO_id")
    @JsonManagedReference
    private List<CreditProfile_MVO> creditProfile;
    private String role;
    @OneToMany
    @JoinColumn(name = "Consumer_MVO_id")
    @JsonManagedReference
    private List<AgreementRef_MVO> agreement;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String description;
    @OneToMany
    @JoinColumn(name = "Consumer_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "Consumer_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> characteristic;
    private String statusReason;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "partyRoleSpecification_id")
    @JsonBackReference
    private PartyRoleSpecificationRef_MVO partyRoleSpecification;
    private String name;
    @OneToMany
    @JoinColumn(name = "Consumer_MVO_id")
    @JsonManagedReference
    private List<PaymentMethodRef_MVO> paymentMethod;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "engagedParty_id")
    @JsonBackReference
    private PartyRef_MVO engagedParty;
    @OneToMany
    @JoinColumn(name = "Consumer_MVO_id")
    @JsonManagedReference
    private List<AccountRef_MVO> account;
    private String status;
}
