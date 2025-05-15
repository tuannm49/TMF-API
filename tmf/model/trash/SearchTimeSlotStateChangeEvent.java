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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchTimeSlotStateChangeEvent implements java.io.Serializable {
    private String eventId;
    private String domain;
    private OffsetDateTime eventTime;
    private String description;
    private String correlationId;
    @Id
    private String id;
    private String href;
    private String eventType;
    private String title;
    private String priority;
    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonBackReference
    private SearchTimeSlotStateChangeEventPayload event;
    private OffsetDateTime timeOcurred;
}
