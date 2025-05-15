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
public class TaskFlow_Update implements java.io.Serializable {
    private String completionMethod;
    @ManyToOne
    @JoinColumn(name = "taskFlowSpecificationRef_id")
    @JsonBackReference
    private TaskFlowSpecificationRef taskFlowSpecificationRef;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Update_id")
    @JsonManagedReference
    private List<RelatedEntity> relatedEntity;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Update_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Update_id")
    @JsonManagedReference
    private List<TaskFlowRelationship> taskFlowRelationship;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskFlowStateType state;
    private Integer priority;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Update_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private Boolean isMandatory;
    private OffsetDateTime requestedStartDate;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Update_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    private OffsetDateTime requestedCompletionDate;
}
