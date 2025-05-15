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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Authorization_MVO implements java.io.Serializable {
    private OffsetDateTime givenDate;
    @OneToMany
    @JoinColumn(name = "Authorization_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> approver;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String signatureRepresentation;
    private OffsetDateTime requestedDate;
    private String state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
