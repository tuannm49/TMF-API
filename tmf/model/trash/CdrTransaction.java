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
public class CdrTransaction implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CdrTransaction_id")
    @JsonManagedReference
    private List<Note> note;
    @ManyToOne
    @JoinColumn(name = "requestedInitialState_id")
    @JsonBackReference
    private CdrTransactionInitialStateType requestedInitialState;
    private String cancellationReason;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "CdrTransaction_id")
    @JsonManagedReference
    private List<RelatedChannel> channel;
    private String description;
    @OneToMany
    @JoinColumn(name = "CdrTransaction_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "CdrTransaction_id")
    @JsonManagedReference
    private List<CdrTransactionItem> transactionItem;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime completionDate;
    private String href;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private CdrTransactionStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime cancellationDate;
}
