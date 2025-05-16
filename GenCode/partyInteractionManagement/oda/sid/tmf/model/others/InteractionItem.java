package oda.sid.tmf.model.others;

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
import oda.sid.tmf.model.others.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InteractionItem extends Extensible implements java.io.Serializable {
    private String reason;
    @OneToMany
    @JoinColumn(name = "InteractionItem_id")
    @JsonManagedReference
    private List<Note> note;
    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonBackReference
    private RelatedEntityRefOrValue item;
    @OneToMany
    @JoinColumn(name = "InteractionItem_id")
    @JsonManagedReference
    private List<InteractionItemRelationship> interactionItemRelationship;
    @ManyToOne
    @JoinColumn(name = "itemDate_id")
    @JsonBackReference
    private TimePeriod itemDate;
    private String interactionItemType;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "InteractionItem_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    private String resolution;
    @OneToMany
    @JoinColumn(name = "InteractionItem_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    private OffsetDateTime lastUpdate;
    @OneToMany
    @JoinColumn(name = "InteractionItem_id")
    @JsonManagedReference
    private List<RelatedChannel> relatedChannel;
    private String id;
}
