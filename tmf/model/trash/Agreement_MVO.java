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
public class Agreement_MVO implements java.io.Serializable {
    private String agreementType;
    @ManyToOne
    @JoinColumn(name = "agreementPeriod_id")
    @JsonBackReference
    private TimePeriod agreementPeriod;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "agreementSpecification_id")
    @JsonBackReference
    private AgreementSpecificationRef_MVO agreementSpecification;
    private String description;
    @OneToMany
    @JoinColumn(name = "Agreement_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private String version;
    private OffsetDateTime initialDate;
    @OneToMany
    @JoinColumn(name = "Agreement_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> characteristic;
    @OneToMany
    @JoinColumn(name = "Agreement_MVO_id")
    @JsonManagedReference
    private List<AgreementRelationship_MVO> agreementRelationship;
    @OneToMany
    @JoinColumn(name = "Agreement_MVO_id")
    @JsonManagedReference
    private List<AgreementAuthorization_MVO> agreementAuthorization;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    @OneToMany
    @JoinColumn(name = "Agreement_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @ManyToOne
    @JoinColumn(name = "completionDate_id")
    @JsonBackReference
    private TimePeriod completionDate;
    private String statementOfIntent;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Agreement_MVO_id")
    @JsonManagedReference
    private List<AgreementItem_MVO> agreementItem;
    @OneToMany
    @JoinColumn(name = "Agreement_MVO_id")
    @JsonManagedReference
    private List<PartyRefOrPartyRoleRef_MVO> engagedParty;
    @OneToMany
    @JoinColumn(name = "Agreement_MVO_id")
    @JsonManagedReference
    private List<RelatedDocumentRefOrValue_MVO> relatedDocument;
    private String status;
}
