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
public class Agreement extends Entity implements java.io.Serializable {
    private String agreementType;
    @ManyToOne
    @JoinColumn(name = "agreementPeriod_id")
    @JsonBackReference
    private TimePeriod agreementPeriod;
    @ManyToOne
    @JoinColumn(name = "agreementSpecification_id")
    @JsonBackReference
    private AgreementSpecificationRef agreementSpecification;
    private String description;
    @OneToMany
    @JoinColumn(name = "Agreement_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    private String version;
    private OffsetDateTime initialDate;
    @OneToMany
    @JoinColumn(name = "Agreement_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @OneToMany
    @JoinColumn(name = "Agreement_id")
    @JsonManagedReference
    private List<AgreementRelationship> agreementRelationship;
    @OneToMany
    @JoinColumn(name = "Agreement_id")
    @JsonManagedReference
    private List<AgreementAuthorization> agreementAuthorization;
    private String name;
    @OneToMany
    @JoinColumn(name = "Agreement_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    @ManyToOne
    @JoinColumn(name = "completionDate_id")
    @JsonBackReference
    private TimePeriod completionDate;
    private String statementOfIntent;
    @OneToMany
    @JoinColumn(name = "Agreement_id")
    @JsonManagedReference
    private List<AgreementItem> agreementItem;
    @OneToMany
    @JoinColumn(name = "Agreement_id")
    @JsonManagedReference
    private List<PartyRefOrPartyRoleRef> engagedParty;
    @OneToMany
    @JoinColumn(name = "Agreement_id")
    @JsonManagedReference
    private List<RelatedDocumentRefOrValue> relatedDocument;
    private String status;
}
