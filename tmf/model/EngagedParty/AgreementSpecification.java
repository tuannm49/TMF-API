package com.example.EngagedParty;

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
public class AgreementSpecification implements java.io.Serializable {
    private Boolean isBundle;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String description;
    @OneToMany
    @JoinColumn(name = "AgreementSpecification_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "AgreementSpecification_id")
    @JsonManagedReference
    private List<AgreementSpecCharacteristic> specificationCharacteristic;
    @ManyToOne
    @JoinColumn(name = "serviceCategory_id")
    @JsonBackReference
    private CategoryRef serviceCategory;
    @OneToMany
    @JoinColumn(name = "AgreementSpecification_id")
    @JsonManagedReference
    private List<AgreementSpecificationRelationship> specificationRelationship;
    @OneToMany
    @JoinColumn(name = "AgreementSpecification_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime lastUpdate;
    private String name;
    @Id
    private String id;
    private String href;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
