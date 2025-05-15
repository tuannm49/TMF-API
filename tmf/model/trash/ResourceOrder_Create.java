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
public class ResourceOrder_Create implements java.io.Serializable {
    private String orderType;
    @OneToMany
    @JoinColumn(name = "ResourceOrder_Create_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "ResourceOrder_Create_id")
    @JsonManagedReference
    private List<ResourceOrderItem> orderItem;
    @JsonProperty("@type")
    private String type;
    private String description;
    private String externalId;
    private Integer priority;
    @OneToMany
    @JoinColumn(name = "ResourceOrder_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private OffsetDateTime requestedStartDate;
    @OneToMany
    @JoinColumn(name = "ResourceOrder_Create_id")
    @JsonManagedReference
    private List<ExternalReference> externalReference;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    private String category;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime startDate;
    private OffsetDateTime requestedCompletionDate;
}
