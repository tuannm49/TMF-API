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
public class BankCard implements java.io.Serializable {
    private OffsetDateTime statusDate;
    @ManyToOne
    @JoinColumn(name = "relatedPlace_id")
    @JsonBackReference
    private RelatedPlace relatedPlace;
    private String cvv;
    private String authorizationCode;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String cardType;
    private String description;
    private Boolean isPreferred;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private RelatedParty relatedParty;
    private String bank;
    private String statusReason;
    @JsonProperty("@baseType")
    private String baseType;
    private String lastFourDigits;
    private String nameOnCard;
    private String name;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String brand;
    @OneToMany
    @JoinColumn(name = "BankCard_id")
    @JsonManagedReference
    private List<AccountRef> account;
    private String cardNumber;
    private String status;
    private OffsetDateTime expirationDate;
}
