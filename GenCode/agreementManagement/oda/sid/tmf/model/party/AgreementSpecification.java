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
public class AgreementSpecification extends Entity implements java.io.Serializable {
    private Boolean isBundle;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String description;
    @OneToMany
    @JoinColumn(name = "AgreementSpecification_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "AgreementSpecification_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> specificationCharacteristic;
    @OneToMany
    @JoinColumn(name = "AgreementSpecification_id")
    @JsonManagedReference
    private List<AgreementSpecificationRelationship> specificationRelationship;
    @OneToMany
    @JoinColumn(name = "AgreementSpecification_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "AgreementSpecification_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private CategoryRef category;
}
