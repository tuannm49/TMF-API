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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachmentRefOrValue implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "size_id")
    @JsonBackReference
    private Quantity size;
    @JsonProperty("@baseType")
    private String baseType;
    private String attachmentType;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String description;
    @Id
    private String id;
    private String href;
    private String mimeType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String content;
    private String url;
}
