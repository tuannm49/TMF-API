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
public class ClosedLoopGroup_MVO implements java.io.Serializable {
    private OffsetDateTime creationdate;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime validfor;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String description;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
