package oda.sid.tmf.model.party;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.tmf.model.party.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Account_id")
    @JsonManagedReference
    private List<TaxExemptionCertificate> taxExemption;
    private OffsetDateTime lastUpdate;
    private String accountType;
    @OneToMany
    @JoinColumn(name = "Account_id")
    @JsonManagedReference
    private List<Contact> contact;
    private String name;
    @ManyToOne
    @JoinColumn(name = "creditLimit_id")
    @JsonBackReference
    private Money creditLimit;
    private String description;
    @OneToMany
    @JoinColumn(name = "Account_id")
    @JsonManagedReference
    private List<AccountRelationship> accountRelationship;
    private String state;
    @OneToMany
    @JoinColumn(name = "Account_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    @OneToMany
    @JoinColumn(name = "Account_id")
    @JsonManagedReference
    private List<AccountBalance> accountBalance;
}
