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
public class CapacitySpecification implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "CapacitySpecification_id")
    @JsonManagedReference
    private List<CapacitySpecification> relatedCapacitySpecification;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "CapacitySpecification_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "CapacitySpecification_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> capacityCharacteristicSpecification;
}
