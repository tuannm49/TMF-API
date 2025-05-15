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
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TroubleTicket implements java.io.Serializable {
    private String statusChangeReason;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_id")
    @JsonManagedReference
    private List<TroubleTicketRelationship> troubleTicketRelationship;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "troubleTicketSpecification_id")
    @JsonBackReference
    private TroubleTicketSpecificationRef troubleTicketSpecification;
    private OffsetDateTime resolutionDate;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    @JsonBackReference
    private ChannelRef channel;
    private String description;
    private OffsetDateTime statusChangeDate;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime requestedResolutionDate;
    private String severity;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_id")
    @JsonManagedReference
    private List<RelatedEntity> relatedEntity;
    private String ticketType;
    private OffsetDateTime creationDate;
    private String priority;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_id")
    @JsonManagedReference
    private List<StatusChange> statusChangeHistory;
    private OffsetDateTime expectedResolutionDate;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_id")
    @JsonManagedReference
    private List<Characteristic> troubleTicketCharacteristic;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private TroubleTicketStatusType status;
}
