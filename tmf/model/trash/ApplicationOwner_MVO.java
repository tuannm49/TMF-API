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
public class ApplicationOwner_MVO implements java.io.Serializable {
    private String statusReason;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String description;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "engagedParty_id")
    @JsonBackReference
    private ApplicationOwnerOrganization_MVO engagedParty;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private ApplicationOwnerStatusType status;
}
