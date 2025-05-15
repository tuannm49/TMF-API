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
public class CancelServiceOrder implements java.io.Serializable {
    private OffsetDateTime requestedCancellationDate;
    @JsonProperty("@baseType")
    private String baseType;
    private String cancellationReason;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "serviceOrder_id")
    @JsonBackReference
    private ServiceOrderRef serviceOrder;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private OffsetDateTime effectiveCancellationDate;
}
