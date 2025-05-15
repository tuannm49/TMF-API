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
public class Partner implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Partner_id")
    @JsonManagedReference
    private List<ContactMedium> contactMedium;
    @OneToMany
    @JoinColumn(name = "Partner_id")
    @JsonManagedReference
    private List<CreditProfile> creditProfile;
    @OneToMany
    @JoinColumn(name = "Partner_id")
    @JsonManagedReference
    private List<AgreementRef> agreement;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "Partner_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @OneToMany
    @JoinColumn(name = "Partner_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    private String statusReason;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    @OneToMany
    @JoinColumn(name = "Partner_id")
    @JsonManagedReference
    private List<PaymentMethodRef> paymentMethod;
    @Id
    private String id;
    private String href;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Partner_id")
    @JsonManagedReference
    private List<AccountRef> account;
    @ManyToOne
    @JoinColumn(name = "engagedParty_id")
    @JsonBackReference
    private RelatedParty engagedParty;
    private String status;
}
