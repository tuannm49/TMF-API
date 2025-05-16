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
import oda.sid.tmf.model.others.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ManagementJob extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ManagementJob_id")
    @JsonManagedReference
    private List<FileTransferData> fileTransferData;
    private String jobId;
    @OneToMany
    @JoinColumn(name = "ManagementJob_id")
    @JsonManagedReference
    private List<ScheduleDefinition> scheduleDefinition;
    private OffsetDateTime lastModifiedTime;
    private OffsetDateTime creationTime;
    @ManyToOne
    @JoinColumn(name = "adminState_id")
    @JsonBackReference
    private AdministrativeState adminState;
    @ManyToOne
    @JoinColumn(name = "executionState_id")
    @JsonBackReference
    private ExecutionStateType executionState;
    @OneToMany
    @JoinColumn(name = "ManagementJob_id")
    @JsonManagedReference
    private List<DataAccessEndpoint> dataAccessEndpoint;
    private Integer jobPriority;
}
