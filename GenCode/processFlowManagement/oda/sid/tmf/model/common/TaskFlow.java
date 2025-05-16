package oda.sid.tmf.model.common;

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
public class TaskFlow implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private OffsetDateTime completionDate;
    private String completionMethod;
    private Boolean isMandatory;
    private Integer priority;
    private OffsetDateTime requestedCompletionDate;
    private OffsetDateTime requestedStartDate;
    private OffsetDateTime startDate;
    private String taskFlowSpecification;
    @OneToMany
    @JoinColumn(name = "TaskFlow_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    @OneToMany
    @JoinColumn(name = "TaskFlow_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @OneToMany
    @JoinColumn(name = "TaskFlow_id")
    @JsonManagedReference
    private List<RelatedEntity> relatedEntity;
    @OneToMany
    @JoinColumn(name = "TaskFlow_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskFlowStateType state;
    @OneToMany
    @JoinColumn(name = "TaskFlow_id")
    @JsonManagedReference
    private List<TaskFlowRelationship> taskFlowRelationship;
    @ManyToOne
    @JoinColumn(name = "taskFlowSpecificationRef_id")
    @JsonBackReference
    private TaskFlowSpecificationRef taskFlowSpecificationRef;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
