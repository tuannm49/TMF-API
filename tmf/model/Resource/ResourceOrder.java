package com.example.Resource;

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
public class ResourceOrder implements java.io.Serializable {
    private String orderType;
    @OneToMany
    @JoinColumn(name = "ResourceOrder_id")
    @JsonManagedReference
    private List<Note> note;
    private String cancellationReason;
    @OneToMany
    @JoinColumn(name = "ResourceOrder_id")
    @JsonManagedReference
    private List<ResourceOrderItem> orderItem;
    @JsonProperty("@type")
    private String type;
    private String description;
    private String externalId;
    private Integer priority;
    @OneToMany
    @JoinColumn(name = "ResourceOrder_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private OffsetDateTime requestedStartDate;
    @OneToMany
    @JoinColumn(name = "ResourceOrder_id")
    @JsonManagedReference
    private List<ExternalReference> externalReference;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    private OffsetDateTime completionDate;
    private OffsetDateTime expectedCompletionDate;
    @Id
    private String id;
    private String href;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ResourceOrderStateType state;
    private String category;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime orderDate;
    private OffsetDateTime startDate;
    private OffsetDateTime cancellationDate;
    private OffsetDateTime requestedCompletionDate;
}
