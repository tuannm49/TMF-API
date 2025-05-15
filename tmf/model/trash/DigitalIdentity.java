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
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DigitalIdentity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "DigitalIdentity_id")
    @JsonManagedReference
    private List<DigitalIdentityContactMedium> contactMedium;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "resourceIdentified_id")
    @JsonBackReference
    private ResourceRef resourceIdentified;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "DigitalIdentity_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "individualIdentified_id")
    @JsonBackReference
    private PartyRef individualIdentified;
    @OneToMany
    @JoinColumn(name = "DigitalIdentity_id")
    @JsonManagedReference
    private List<RelatedParty> partyRoleIdentified;
    @OneToMany
    @JoinColumn(name = "DigitalIdentity_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @OneToMany
    @JoinColumn(name = "DigitalIdentity_id")
    @JsonManagedReference
    private List<Credential> credential;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime lastUpdate;
    private String nickname;
    @Id
    private String id;
    private String href;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String status;
}
