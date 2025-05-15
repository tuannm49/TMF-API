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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceOrderErrorMessage implements java.io.Serializable {
    private String reason;
    @OneToMany
    @JoinColumn(name = "ServiceOrderErrorMessage_id")
    @JsonManagedReference
    private List<ServiceOrderItemRef> serviceOrderItem;
    private String code;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String message;
    private String referenceError;
    private String status;
    private OffsetDateTime timestamp;
}
