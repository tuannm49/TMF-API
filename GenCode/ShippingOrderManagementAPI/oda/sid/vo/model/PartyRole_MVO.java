package oda.sid.vo.model;

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
import oda.sid.vo.model.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyRole_MVO extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PartyRole_MVO_id")
    @JsonManagedReference
    private List<ContactMedium_MVO> contactMedium;
    @OneToMany
    @JoinColumn(name = "PartyRole_MVO_id")
    @JsonManagedReference
    private List<CreditProfile_MVO> creditProfile;
    private String role;
    @OneToMany
    @JoinColumn(name = "PartyRole_MVO_id")
    @JsonManagedReference
    private List<AgreementRef_MVO> agreement;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String description;
    @OneToMany
    @JoinColumn(name = "PartyRole_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "PartyRole_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> characteristic;
    private String statusReason;
    @ManyToOne
    @JoinColumn(name = "partyRoleSpecification_id")
    @JsonBackReference
    private PartyRoleSpecificationRef_MVO partyRoleSpecification;
    private String name;
    @OneToMany
    @JoinColumn(name = "PartyRole_MVO_id")
    @JsonManagedReference
    private List<PaymentMethodRef_MVO> paymentMethod;
    @ManyToOne
    @JoinColumn(name = "engagedParty_id")
    @JsonBackReference
    private PartyRef_MVO engagedParty;
    @OneToMany
    @JoinColumn(name = "PartyRole_MVO_id")
    @JsonManagedReference
    private List<AccountRef_MVO> account;
    private String status;
}
