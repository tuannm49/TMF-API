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
public class CdrTransaction_MVO extends Entity_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CdrTransaction_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    @OneToMany
    @JoinColumn(name = "CdrTransaction_MVO_id")
    @JsonManagedReference
    private List<CdrTransactionItem_MVO> transactionItem;
    @ManyToOne
    @JoinColumn(name = "requestedInitialState_id")
    @JsonBackReference
    private CdrTransactionInitialStateType requestedInitialState;
    private String cancellationReason;
    @OneToMany
    @JoinColumn(name = "CdrTransaction_MVO_id")
    @JsonManagedReference
    private List<RelatedChannel_MVO> channel;
    private String description;
    private OffsetDateTime completionDate;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private CdrTransactionStateType state;
    @OneToMany
    @JoinColumn(name = "CdrTransaction_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private OffsetDateTime creationDate;
    private OffsetDateTime cancellationDate;
}
