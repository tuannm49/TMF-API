package com.example.Common;

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
public class Document implements java.io.Serializable {
    private String lifecycleState;
    @ManyToOne
    @JoinColumn(name = "documentSpecification_id")
    @JsonBackReference
    private DocumentSpecificationRefOrValue documentSpecification;
    private String documentType;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "relatedEntity_id")
    @JsonBackReference
    private RelatedEntity relatedEntity;
    private String description;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "Document_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "Document_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    private OffsetDateTime expiryDate;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "Document_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "Document_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Document_id")
    @JsonManagedReference
    private List<CategoryRef> category;
    @OneToMany
    @JoinColumn(name = "Document_id")
    @JsonManagedReference
    private List<DocumentRefOrValue> documentRelationship;
}
