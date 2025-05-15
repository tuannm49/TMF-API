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
public class DunningWriteOff implements java.io.Serializable {
    private String reason;
    @ManyToOne
    @JoinColumn(name = "amount_id")
    @JsonBackReference
    private Money amount;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    @Id
    private String id;
    private OffsetDateTime creationDate;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String status;
}
