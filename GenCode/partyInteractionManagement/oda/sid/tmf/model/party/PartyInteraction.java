package oda.sid.tmf.model.party;

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
import oda.sid.tmf.model.party.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyInteraction extends Entity implements java.io.Serializable {
    private String reason;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_id")
    @JsonManagedReference
    private List<Note> note;
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
    private String direction;
    private String status;
}
