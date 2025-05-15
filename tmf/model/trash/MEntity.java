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
public class MEntity implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "MEntity_id")
    @JsonManagedReference
    private List<Note> note;
    private Boolean isExternal;
    @OneToMany
    @JoinColumn(name = "MEntity_id")
    @JsonManagedReference
    private List<EntityRelationship> entityRelationship;
    private OffsetDateTime endDate;
    @JsonProperty("@type")
    private String type;
    private String description;
    @OneToMany
    @JoinColumn(name = "MEntity_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "MEntity_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    private OffsetDateTime statusChangeDate;
    @OneToMany
    @JoinColumn(name = "MEntity_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @JsonProperty("@baseType")
    private String baseType;
    private String context;
    private String name;
    @Id
    private String id;
    private String href;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime startDate;
    @ManyToOne
    @JoinColumn(name = "entitySpecification_id")
    @JsonBackReference
    private EntitySpecificationRef entitySpecification;
    private String status;
}
