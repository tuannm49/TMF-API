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
public class CapacitySpecification_MVO implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "CapacitySpecification_MVO_id")
    @JsonManagedReference
    private List<CapacitySpecification_MVO> relatedCapacitySpecification;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "CapacitySpecification_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "CapacitySpecification_MVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_MVO> capacityCharacteristicSpecification;
}
