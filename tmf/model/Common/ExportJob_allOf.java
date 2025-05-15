package com.example.Common;

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
public class ExportJob_allOf implements java.io.Serializable {
    private String path;
    private String query;
    private OffsetDateTime completionDate;
    private String errorLog;
    @Id
    private String id;
    private OffsetDateTime creationDate;
    private String contentType;
    private String url;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private JobStateType status;
}
