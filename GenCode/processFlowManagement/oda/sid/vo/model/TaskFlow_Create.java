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
public class TaskFlow_Create implements java.io.Serializable {
    private OffsetDateTime completionDate;
    private OffsetDateTime requestedCompletionDate;
    private OffsetDateTime requestedStartDate;
    private OffsetDateTime startDate;
    private String taskFlowSpecification;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Create_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Create_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Create_id")
    @JsonManagedReference
    private List<RelatedEntity> relatedEntity;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @OneToMany
    @JoinColumn(name = "TaskFlow_Create_id")
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
