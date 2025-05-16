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
public class ProcessFlow implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private OffsetDateTime processFlowDate;
    private String processFlowSpecification;
    @OneToMany
    @JoinColumn(name = "ProcessFlow_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    @OneToMany
    @JoinColumn(name = "ProcessFlow_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @ManyToOne
    @JoinColumn(name = "processFlowSpecificationRef_id")
    @JsonBackReference
    private ProcessFlowSpecificationRef processFlowSpecificationRef;
    @OneToMany
    @JoinColumn(name = "ProcessFlow_id")
    @JsonManagedReference
    private List<RelatedEntity> relatedEntity;
    @OneToMany
    @JoinColumn(name = "ProcessFlow_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ProcessFlowStateType state;
    @OneToMany
    @JoinColumn(name = "ProcessFlow_id")
    @JsonManagedReference
    private List<TaskFlowRef> taskFlow;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
