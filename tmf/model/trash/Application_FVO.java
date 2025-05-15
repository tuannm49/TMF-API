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
public class Application_FVO implements java.io.Serializable {
    private List<String> redirectUrl;
    @JsonProperty("@type")
    private String type;
    private String resourceVersion;
    @ManyToOne
    @JoinColumn(name = "applicationOwner_id")
    @JsonBackReference
    private PartyRoleRef_FVO applicationOwner;
    private String description;
    private String jwksUri;
    private String privacyPolicyURL;
    private String logoUrl;
    @ManyToOne
    @JoinColumn(name = "digitalIdentity_id")
    @JsonBackReference
    private ApiDigitalIdentity_FVO digitalIdentity;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "Application_FVO_id")
    @JsonManagedReference
    private List<ContactMedium_FVO> privacyRightsRequestContact;
    private String name;
    @OneToMany
    @JoinColumn(name = "Application_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String category;
    private String commercialName;
}
