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
public class BaseEvent_FVO implements java.io.Serializable {
    private String eventId;
    @JsonProperty("@type")
    private String type;
    private String description;
    private String eventType;
    private String title;
    private String priority;
    private OffsetDateTime timeOcurred;
    @JsonProperty("@baseType")
    private String baseType;
    private String domain;
    private OffsetDateTime eventTime;
    private String correlationId;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private Object event;
}
