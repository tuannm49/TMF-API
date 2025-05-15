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
public class CancelResourceOrder implements java.io.Serializable {
    private OffsetDateTime requestedCancellationDate;
    @ManyToOne
    @JoinColumn(name = "resourceOrder_id")
    @JsonBackReference
    private ResourceOrderRef resourceOrder;
    @JsonProperty("@baseType")
    private String baseType;
    private String cancellationReason;
    @JsonProperty("@type")
    private String type;
    @Id
    private String id;
    private String href;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime effectiveCancellationDate;
}
