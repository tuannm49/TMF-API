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
public class PartyInteraction_FVO implements java.io.Serializable {
    private String reason;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_FVO_id")
    @JsonManagedReference
    private List<Note_FVO> note;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_FVO_id")
    @JsonManagedReference
    private List<InteractionRelationship_FVO> interactionRelationship;
    private String description;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_FVO> relatedParty;
    @ManyToOne
    @JoinColumn(name = "interactionDate_id")
    @JsonBackReference
    private TimePeriod interactionDate;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_FVO_id")
    @JsonManagedReference
    private List<InteractionItem_FVO> interactionItem;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_FVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_FVO> attachment;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_FVO_id")
    @JsonManagedReference
    private List<RelatedChannel_FVO> relatedChannel;
    private OffsetDateTime lastUpdate;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String direction;
    private String status;
}
