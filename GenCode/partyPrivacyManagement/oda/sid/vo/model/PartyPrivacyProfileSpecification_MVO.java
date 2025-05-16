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
public class PartyPrivacyProfileSpecification_MVO extends Entity_MVO implements java.io.Serializable {
    private String lifecycleStatus;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyProfileSpecification_MVO_id")
    @JsonManagedReference
    private List<ProductOfferingRef_MVO> productOffering;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private OffsetDateTime lastUpdate;
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyProfileSpecification_MVO_id")
    @JsonManagedReference
    private List<PartyPrivacyRoleSpecification_MVO> applicableRole;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyProfileSpecification_MVO_id")
    @JsonManagedReference
    private List<PartyPrivacyProfileSpecificationCharacteristic_MVO> specCharacteristic;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyProfileSpecification_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private String version;
}
