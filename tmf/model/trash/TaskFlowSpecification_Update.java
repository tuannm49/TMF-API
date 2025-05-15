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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskFlowSpecification_Update implements java.io.Serializable {
    private String taskFlowSpecificationType;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_Update_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    private String description;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_Update_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_Update_id")
    @JsonManagedReference
    private List<TaskFlowSpecificationRelationship> taskFlowSpecificationRelationship;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_Update_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_Update_id")
    @JsonManagedReference
    private List<RelatedEntitySpecification> relatedEntitySpecification;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_Update_id")
    @JsonManagedReference
    private List<TaskFlowSpecification> taskFlowSpecification;
    private String name;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_Update_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> taskFlowSpecificationCharacteristic;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_Update_id")
    @JsonManagedReference
    private List<RelatedEntitySpecification> relatedProcessFlowSpecification;
}
