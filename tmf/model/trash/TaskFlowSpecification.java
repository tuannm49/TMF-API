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
public class TaskFlowSpecification implements java.io.Serializable {
    private String taskFlowSpecificationType;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    private String description;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_id")
    @JsonManagedReference
    private List<TaskFlowSpecificationRelationship> taskFlowSpecificationRelationship;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_id")
    @JsonManagedReference
    private List<RelatedEntitySpecification> relatedEntitySpecification;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_id")
    @JsonManagedReference
    private List<TaskFlowSpecification> taskFlowSpecification;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> taskFlowSpecificationCharacteristic;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_id")
    @JsonManagedReference
    private List<RelatedEntitySpecification> relatedProcessFlowSpecification;
    @Id
    private String id;
    private String href;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
