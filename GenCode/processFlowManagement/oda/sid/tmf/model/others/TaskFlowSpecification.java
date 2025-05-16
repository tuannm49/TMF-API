package oda.sid.tmf.model.others;

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
public class TaskFlowSpecification implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private String description;
    private OffsetDateTime lastUpdate;
    private String lifecycleStatus;
    private String name;
    private String taskFlowSpecificationType;
    private String version;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_id")
    @JsonManagedReference
    private List<RelatedEntitySpecification> relatedEntitySpecification;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_id")
    @JsonManagedReference
    private List<RelatedEntitySpecification> relatedProcessFlowSpecification;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_id")
    @JsonManagedReference
    private List<TaskFlowSpecification> taskFlowSpecification;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> taskFlowSpecificationCharacteristic;
    @OneToMany
    @JoinColumn(name = "TaskFlowSpecification_id")
    @JsonManagedReference
    private List<TaskFlowSpecificationRelationship> taskFlowSpecificationRelationship;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
