package oda.sid.vo.model;

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
import oda.sid.vo.model.Entity_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TroubleTicket_FVO extends Entity_FVO implements java.io.Serializable {
    private String severity;
    private String statusChangeReason;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_FVO_id")
    @JsonManagedReference
    private List<Note_FVO> note;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_FVO_id")
    @JsonManagedReference
    private List<TroubleTicketRelationship_FVO> troubleTicketRelationship;
    @ManyToOne
    @JoinColumn(name = "troubleTicketSpecification_id")
    @JsonBackReference
    private TroubleTicketSpecificationRef_FVO troubleTicketSpecification;
    private OffsetDateTime resolutionDate;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_FVO_id")
    @JsonManagedReference
    private List<RelatedEntity_FVO> relatedEntity;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    @JsonBackReference
    private ChannelRef_FVO channel;
    private String description;
    private String ticketType;
    private String priority;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    private OffsetDateTime statusChangeDate;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_FVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_FVO> attachment;
    private OffsetDateTime expectedResolutionDate;
    private String name;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> troubleTicketCharacteristic;
    @OneToMany
    @JoinColumn(name = "TroubleTicket_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    private OffsetDateTime requestedResolutionDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private TroubleTicketStatusType status;
}
