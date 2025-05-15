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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceProblemEventRecord_FVO implements java.io.Serializable {
    private OffsetDateTime eventTime;
    @ManyToOne
    @JoinColumn(name = "serviceProblem_id")
    @JsonBackReference
    private ServiceProblemRef_FVO serviceProblem;
    @ManyToOne
    @JoinColumn(name = "notification_id")
    @JsonBackReference
    private Any_FVO notification;
    @Id
    private String id;
    private String eventType;
    private OffsetDateTime recordTime;
}
