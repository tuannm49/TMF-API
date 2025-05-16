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
import java.util.List;
import oda.sid.tmf.model.party.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Party extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Party_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalReference;
    @OneToMany
    @JoinColumn(name = "Party_id")
    @JsonManagedReference
    private List<TaxExemptionCertificate> taxExemptionCertificate;
    @OneToMany
    @JoinColumn(name = "Party_id")
    @JsonManagedReference
    private List<Characteristic> partyCharacteristic;
    @OneToMany
    @JoinColumn(name = "Party_id")
    @JsonManagedReference
    private List<ContactMedium> contactMedium;
    @OneToMany
    @JoinColumn(name = "Party_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> relatedParty;
    @OneToMany
    @JoinColumn(name = "Party_id")
    @JsonManagedReference
    private List<PartyCreditProfile> creditRating;
}
