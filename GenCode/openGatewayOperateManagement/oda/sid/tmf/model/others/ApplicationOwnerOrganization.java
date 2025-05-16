package oda.sid.tmf.model.others;

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
import oda.sid.tmf.model.others.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationOwnerOrganization extends Extensible implements java.io.Serializable {
    private String tradingName;
    @OneToMany
    @JoinColumn(name = "ApplicationOwnerOrganization_id")
    @JsonManagedReference
    private List<ContactMedium> contactMedium;
    @ManyToOne
    @JoinColumn(name = "dataProtectionOfficer_id")
    @JsonBackReference
    private ApplicationOwnerPartyOrPartyRole dataProtectionOfficer;
    @ManyToOne
    @JoinColumn(name = "privacyManager_id")
    @JsonBackReference
    private ApplicationOwnerPartyOrPartyRole privacyManager;
    private String taxNumber;
    private String privacyPolicyURL;
    @ManyToOne
    @JoinColumn(name = "registeredGeographicAddress_id")
    @JsonBackReference
    private LightGeographicAddress registeredGeographicAddress;
    private String nameType;
    private String organizationType;
    @OneToMany
    @JoinColumn(name = "ApplicationOwnerOrganization_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalReference;
    @ManyToOne
    @JoinColumn(name = "legalRepresentative_id")
    @JsonBackReference
    private ApplicationOwnerRelatedIndividual legalRepresentative;
    private String name;
    @OneToMany
    @JoinColumn(name = "ApplicationOwnerOrganization_id")
    @JsonManagedReference
    private List<ApplicationOwnerRelatedLocalRepresentative> localRepresentative;
    private Boolean isLegalEntity;
    @OneToMany
    @JoinColumn(name = "ApplicationOwnerOrganization_id")
    @JsonManagedReference
    private List<OrganizationIdentification> organizationIdentification;
}
