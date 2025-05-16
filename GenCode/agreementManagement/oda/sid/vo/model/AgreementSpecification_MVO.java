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
public class AgreementSpecification_MVO extends Entity implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "AgreementSpecification_MVO_id")
    @JsonManagedReference
    private List<AgreementSpecificationRelationship_MVO> specificationRelationship;
    private String lifecycleStatus;
    @OneToMany
    @JoinColumn(name = "AgreementSpecification_MVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "AgreementSpecification_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private CategoryRef_MVO category;
    @OneToMany
    @JoinColumn(name = "AgreementSpecification_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "AgreementSpecification_MVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_MVO> specificationCharacteristic;
}
