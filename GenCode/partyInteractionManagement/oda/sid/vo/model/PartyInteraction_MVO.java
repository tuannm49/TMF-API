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
import oda.sid.vo.model.Entity_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyInteraction_MVO extends Entity_MVO implements java.io.Serializable {
    private String reason;
    @ManyToOne
    @JoinColumn(name = "interactionDate_id")
    @JsonBackReference
    private TimePeriod interactionDate;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_MVO_id")
    @JsonManagedReference
    private List<InteractionItem_MVO> interactionItem;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_MVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_MVO> attachment;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_MVO_id")
    @JsonManagedReference
    private List<InteractionRelationship_MVO> interactionRelationship;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_MVO_id")
    @JsonManagedReference
    private List<RelatedChannel_MVO> relatedChannel;
    private OffsetDateTime lastUpdate;
    private String description;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "PartyInteraction_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> relatedParty;
    private String status;
}
