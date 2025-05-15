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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactMedium implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String mediumType;
    @Id
    private String id;
    private String href;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private Boolean preferred;
    @ManyToOne
    @JoinColumn(name = "characteristic_id")
    @JsonBackReference
    private MediumCharacteristic characteristic;
}
