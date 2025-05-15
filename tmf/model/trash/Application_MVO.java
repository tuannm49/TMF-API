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
public class Application_MVO implements java.io.Serializable {
    private List<String> redirectUrl;
    @JsonProperty("@type")
    private String type;
    private String resourceVersion;
    private String description;
    private String jwksUri;
    private String privacyPolicyURL;
    private String logoUrl;
    private String approvalStatusReason;
    @ManyToOne
    @JoinColumn(name = "digitalIdentity_id")
    @JsonBackReference
    private ApiDigitalIdentity_MVO digitalIdentity;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "Application_MVO_id")
    @JsonManagedReference
    private List<ContactMedium_MVO> privacyRightsRequestContact;
    private String name;
    @OneToMany
    @JoinColumn(name = "Application_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    private String href;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "operationalState_id")
    @JsonBackReference
    private ResourceOperationalStateType operationalState;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String category;
    private String commercialName;
}
