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
public class Customer360TroubleTicketVO implements java.io.Serializable {
    private String severity;
    private String statusChangeReason;
    @JsonProperty("@type")
    private String type;
    private String description;
    private String ticketType;
    private OffsetDateTime creationDate;
    private String priority;
    private OffsetDateTime statusChangeDate;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime expectedResolutionDate;
    private OffsetDateTime lastUpdate;
    private String name;
    private String externalIdentifier;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime requestedResolutionDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private TroubleTicketStatusType status;
}
