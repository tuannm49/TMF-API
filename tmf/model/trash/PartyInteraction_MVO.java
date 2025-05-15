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
public class PartyInteraction_MVO implements java.io.Serializable {
    private String reason;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_MVO_id")
    @JsonManagedReference
    private List<InteractionRelationship_MVO> interactionRelationship;
    private String description;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> relatedParty;
    @ManyToOne
    @JoinColumn(name = "interactionDate_id")
    @JsonBackReference
    private TimePeriod interactionDate;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_MVO_id")
    @JsonManagedReference
    private List<InteractionItem_MVO> interactionItem;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_MVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_MVO> attachment;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_MVO_id")
    @JsonManagedReference
    private List<RelatedChannel_MVO> relatedChannel;
    private OffsetDateTime lastUpdate;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String status;
}
