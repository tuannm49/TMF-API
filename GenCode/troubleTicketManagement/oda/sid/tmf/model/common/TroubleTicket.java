package oda.sid.tmf.model.common;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.tmf.model.common.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TroubleTicket extends Entity implements java.io.Serializable {
    private String severity;
    private String statusChangeReason;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_id")
    @JsonManagedReference
    private List<TroubleTicketRelationship> troubleTicketRelationship;
    @ManyToOne
    @JoinColumn(name = "troubleTicketSpecification_id")
    @JsonBackReference
    private TroubleTicketSpecificationRef troubleTicketSpecification;
    private OffsetDateTime resolutionDate;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_id")
    @JsonManagedReference
    private List<RelatedEntity> relatedEntity;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    @JsonBackReference
    private ChannelRef channel;
    private String description;
    private String ticketType;
    private OffsetDateTime creationDate;
    private String priority;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    private OffsetDateTime statusChangeDate;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
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
    @OneToMany
    @JoinColumn(name = "TroubleTicket_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    private OffsetDateTime requestedResolutionDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private TroubleTicketStatusType status;
}
