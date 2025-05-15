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
public class CancelWorkOrder_FVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "workOrder_id")
    @JsonBackReference
    private WorkOrderRef_FVO workOrder;
    private OffsetDateTime requestedCancellationDate;
    @JsonProperty("@baseType")
    private String baseType;
    private String cancellationReason;
    @JsonProperty("@type")
    private String type;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
