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
public class ManagementJob implements java.io.Serializable {
    private OffsetDateTime lastModifiedTime;
    private OffsetDateTime creationTime;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "executionState_id")
    @JsonBackReference
    private ExecutionStateType executionState;
    @OneToMany
    @JoinColumn(name = "ManagementJob_id")
    @JsonManagedReference
    private List<FileTransferData> fileTransferData;
    private String jobId;
    @OneToMany
    @JoinColumn(name = "ManagementJob_id")
    @JsonManagedReference
    private List<ScheduleDefinition> scheduleDefinition;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "adminState_id")
    @JsonBackReference
    private AdministrativeState adminState;
    @OneToMany
    @JoinColumn(name = "ManagementJob_id")
    @JsonManagedReference
    private List<DataAccessEndpoint> dataAccessEndpoint;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private Integer jobPriority;
}
