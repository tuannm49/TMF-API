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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyDomain implements java.io.Serializable {
    private String lifecycleState;
    @OneToMany
    @JoinColumn(name = "PolicyDomain_id")
    @JsonManagedReference
    private List<Note> note;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "PolicyDomain_id")
    @JsonManagedReference
    private List<Reference> subDomainRef;
    private String description;
    private String version;
    @OneToMany
    @JoinColumn(name = "PolicyDomain_id")
    @JsonManagedReference
    private List<Reference> scopedManagedEntity;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
