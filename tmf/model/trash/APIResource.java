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
public class ApiResource implements java.io.Serializable {
    private String identifier;
    private OffsetDateTime createdDate;
    @ManyToOne
    @JoinColumn(name = "application_id")
    @JsonBackReference
    private ApplicationRef application;
    @OneToMany
    @JoinColumn(name = "ApiResource_id")
    @JsonManagedReference
    private List<ScopeRef> scope;
    private String name;
    @Id
    private String id;
    private OffsetDateTime updatedDate;
}
