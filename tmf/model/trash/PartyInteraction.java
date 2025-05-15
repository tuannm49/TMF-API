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
public class PartyInteraction implements java.io.Serializable {
    private String reason;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_id")
    @JsonManagedReference
    private List<Note> note;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_id")
    @JsonManagedReference
    private List<InteractionRelationship> interactionRelationship;
    private String description;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> relatedParty;
    private OffsetDateTime statusChangeDate;
    @ManyToOne
    @JoinColumn(name = "interactionDate_id")
    @JsonBackReference
    private TimePeriod interactionDate;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_id")
    @JsonManagedReference
    private List<InteractionItem> interactionItem;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_id")
    @JsonManagedReference
    private List<RelatedChannel> relatedChannel;
    private OffsetDateTime lastUpdate;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String direction;
    private String status;
}
