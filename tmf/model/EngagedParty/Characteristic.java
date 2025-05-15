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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Characteristic implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Characteristic_id")
    @JsonManagedReference
    private List<CharacteristicRelationship> characteristicRelationship;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    private String valueType;
    private String name;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
