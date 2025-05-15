package com.example.Service;

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
public class ServiceProblemEventRecord implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "serviceProblem_id")
    @JsonBackReference
    private ServiceProblemRef serviceProblem;
    @ManyToOne
    @JoinColumn(name = "notification_id")
    @JsonBackReference
    private Any notification;
    private OffsetDateTime recordTime;
    private OffsetDateTime eventTime;
    private String href;
    @Id
    private String id;
    private String eventType;
}
