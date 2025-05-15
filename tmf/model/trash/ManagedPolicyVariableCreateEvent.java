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
public class ManagedPolicyVariableCreateEvent implements java.io.Serializable {
    private String eventId;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ManagedPolicyVariableCreateEvent_id")
    @JsonManagedReference
    private List<Characteristic> analyticCharacteristic;
    private String description;
    @ManyToOne
    @JoinColumn(name = "source_id")
    @JsonBackReference
    private EntityRef source;
    private String eventType;
    private String title;
    private String priority;
    @OneToMany
    @JoinColumn(name = "ManagedPolicyVariableCreateEvent_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    private String domain;
    private OffsetDateTime eventTime;
    @ManyToOne
    @JoinColumn(name = "reportingSystem_id")
    @JsonBackReference
    private EntityRef reportingSystem;
    private String correlationId;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonBackReference
    private ManagedPolicyVariableCreateEventPayload event;
    private OffsetDateTime timeOccurred;
}
