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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetadataCatalog_Create implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "MetadataCatalog_Create_id")
    @JsonManagedReference
    private List<MetadataCategoryRef> metadataCategory;
    @ManyToOne
    @JoinColumn(name = "attachment_id")
    @JsonBackReference
    private Attachment attachment;
    @JsonProperty("@baseType")
    private String baseType;
    private String lastUpdateDate;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "MetadataCatalog_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String version;
}
