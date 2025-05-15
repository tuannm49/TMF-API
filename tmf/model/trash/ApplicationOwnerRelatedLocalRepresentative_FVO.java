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
public class ApplicationOwnerRelatedLocalRepresentative_FVO implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "representative_id")
    @JsonBackReference
    private ApplicationOwnerRelatedIndividual_FVO representative;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "countryCode_id")
    @JsonBackReference
    private ISO31661Alpha2StandardIdentifier_FVO countryCode;
}
