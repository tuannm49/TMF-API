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
public class DirectDebit implements java.io.Serializable {
    private OffsetDateTime statusDate;
    @ManyToOne
    @JoinColumn(name = "relatedPlace_id")
    @JsonBackReference
    private RelatedPlace relatedPlace;
    private String authorizationCode;
    private String signature;
    @JsonProperty("@type")
    private String type;
    private String description;
    private String reference;
    private String bank;
    private String statusReason;
    @JsonProperty("@baseType")
    private String baseType;
    private String mandateCategory;
    @OneToMany
    @JoinColumn(name = "DirectDebit_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    private String mandateType;
    private String mandateStatus;
    private String mandateId;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime mandateStatusDate;
    private String BIC;
    private OffsetDateTime cancellationDate;
    private String owner;
    private String accountNumberType;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private Boolean isPreferred;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private RelatedParty relatedParty;
    private String accountNumber;
    private OffsetDateTime signatureDate;
    private OffsetDateTime lastDebitDate;
    private String name;
    private OffsetDateTime firstDebitDate;
    @OneToMany
    @JoinColumn(name = "DirectDebit_id")
    @JsonManagedReference
    private List<AccountRef> account;
    private String status;
}
