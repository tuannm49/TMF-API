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
public class TaskFlow_Create implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "taskFlowSpecificationRef_id")
    @JsonBackReference
    private TaskFlowSpecificationRef taskFlowSpecificationRef;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Create_id")
    @JsonManagedReference
    private List<RelatedEntity> relatedEntity;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Create_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Create_id")
    @JsonManagedReference
    private List<TaskFlowRelationship> taskFlowRelationship;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private OffsetDateTime requestedStartDate;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Create_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @JsonProperty("@baseType")
    private String baseType;
    private String taskFlowSpecification;
    private OffsetDateTime completionDate;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime startDate;
    private OffsetDateTime requestedCompletionDate;
}
