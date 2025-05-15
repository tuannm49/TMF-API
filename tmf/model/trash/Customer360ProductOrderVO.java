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
public class Customer360ProductOrderVO implements java.io.Serializable {
    @JsonProperty("@type")
    private String type;
    private String description;
    private String externalId;
    private OffsetDateTime creationDate;
    private String priority;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime completionDate;
    private OffsetDateTime expectedCompletionDate;
    private String href;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ProductOrderStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String category;
}
