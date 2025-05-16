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
public class CdrTransaction_FVO extends Entity_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CdrTransaction_FVO_id")
    @JsonManagedReference
    private List<Note_FVO> note;
    @OneToMany
    @JoinColumn(name = "CdrTransaction_FVO_id")
    @JsonManagedReference
    private List<CdrTransactionItem_FVO> transactionItem;
    @ManyToOne
    @JoinColumn(name = "requestedInitialState_id")
    @JsonBackReference
    private CdrTransactionInitialStateType requestedInitialState;
    private String cancellationReason;
    @OneToMany
    @JoinColumn(name = "CdrTransaction_FVO_id")
    @JsonManagedReference
    private List<RelatedChannel_FVO> channel;
    private String description;
    private OffsetDateTime completionDate;
    @OneToMany
    @JoinColumn(name = "CdrTransaction_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    private OffsetDateTime creationDate;
    private OffsetDateTime cancellationDate;
}
