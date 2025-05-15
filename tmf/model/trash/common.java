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
public class common implements java.io.Serializable {
    @JsonProperty("@base")
    private String base;
    @JsonProperty("@value")
    private String value;
    @JsonProperty("@vocab")
    private String vocab;
    @JsonProperty("@language")
    private String language;
    @JsonProperty("@type")
    private String type;
    @JsonProperty("@list")
    private Object list;
    @JsonProperty("@id")
    private String id;
    @JsonProperty("@reverse")
    private Object reverse;
    @JsonProperty("@container")
    private String container;
    @JsonProperty("@set")
    private Object set;
}
