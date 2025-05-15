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
public class MetadataCatalog_Update implements java.io.Serializable {
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "MetadataCatalog_Update_id")
    @JsonManagedReference
    private List<MetadataCategoryRef> metadataCategory;
    @ManyToOne
    @JoinColumn(name = "attachment_id")
    @JsonBackReference
    private Attachment attachment;
    @OneToMany
    @JoinColumn(name = "MetadataCatalog_Update_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private String version;
}
