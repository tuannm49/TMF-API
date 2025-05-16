package oda.sid.vo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskFlow_Update implements java.io.Serializable {
    private String completionMethod;
    private Boolean isMandatory;
    private Integer priority;
    private OffsetDateTime requestedCompletionDate;
    private OffsetDateTime requestedStartDate;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Update_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Update_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Update_id")
    @JsonManagedReference
    private List<RelatedEntity> relatedEntity;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Update_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskFlowStateType state;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Update_id")
    @JsonManagedReference
    private List<TaskFlowRelationship> taskFlowRelationship;
    @ManyToOne
    @JoinColumn(name = "taskFlowSpecificationRef_id")
    @JsonBackReference
    private TaskFlowSpecificationRef taskFlowSpecificationRef;
}
