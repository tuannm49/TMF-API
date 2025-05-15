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
public class PartyPrivacyProfileSpecificationCharacteristic_FVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String privacyUsagePurpose;
    @JsonProperty("@type")
    private String type;
    @JsonProperty("@valueSchemaLocation")
    private String valueSchemaLocation;
    private Boolean isUnique;
    private String description;
    private String criticalityLevel;
    private Integer maxCardinality;
    private Integer minCardinality;
    private String regex;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyProfileSpecificationCharacteristic_FVO_id")
    @JsonManagedReference
    private List<PartyRoleSpecificationRef_FVO> allowedRole;
    private String valueType;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyProfileSpecificationCharacteristic_FVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecificationRelationship_FVO> charSpecRelationship;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyProfileSpecificationCharacteristic_FVO_id")
    @JsonManagedReference
    private List<CharacteristicValueSpecification_FVO> characteristicValueSpecification;
    private String name;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private Boolean extensible;
    private Boolean configurable;
    private String privacyType;
}
