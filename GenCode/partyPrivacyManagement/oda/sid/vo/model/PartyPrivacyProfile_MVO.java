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
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.vo.model.Entity_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyPrivacyProfile_MVO extends Entity_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PartyPrivacyProfile_MVO_id")
    @JsonManagedReference
    private List<PartyPrivacyProfileCharacteristic_MVO> partyPrivacyProfileCharacteristic;
    @ManyToOne
    @JoinColumn(name = "agreement_id")
    @JsonBackReference
    private PartyPrivacyAgreementRef_MVO agreement;
    @ManyToOne
    @JoinColumn(name = "applicableForParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_MVO applicableForParty;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private OffsetDateTime lastUpdate;
    @ManyToOne
    @JoinColumn(name = "agreedByParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_MVO agreedByParty;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "partyPrivacyProfileSpecification_id")
    @JsonBackReference
    private PartyPrivacyProfileSpecificationRef_MVO partyPrivacyProfileSpecification;
    private String status;
}
