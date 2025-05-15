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
public class CdrTransaction_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CdrTransaction_MVO_id")
    @JsonManagedReference
    private List<Note_MVO> note;
    @ManyToOne
    @JoinColumn(name = "requestedInitialState_id")
    @JsonBackReference
    private CdrTransactionInitialStateType requestedInitialState;
    private String cancellationReason;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "CdrTransaction_MVO_id")
    @JsonManagedReference
    private List<RelatedChannel_MVO> channel;
    private String description;
    @OneToMany
    @JoinColumn(name = "CdrTransaction_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "CdrTransaction_MVO_id")
    @JsonManagedReference
    private List<CdrTransactionItem_MVO> transactionItem;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime completionDate;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private CdrTransactionStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime cancellationDate;
}
