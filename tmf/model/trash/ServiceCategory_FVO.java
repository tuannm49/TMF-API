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
public class ServiceCategory_FVO implements java.io.Serializable {
    private String lifecycleStatus;
    private Boolean isRoot;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "ServiceCategory_FVO_id")
    @JsonManagedReference
    private List<ServiceCandidateRef_FVO> serviceCandidate;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ServiceCategory_FVO_id")
    @JsonManagedReference
    private List<ServiceSpecificationRef_FVO> serviceSpecification;
    private String description;
    private String version;
    private String parentId;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime lastUpdate;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "ServiceCategory_FVO_id")
    @JsonManagedReference
    private List<ServiceCategoryRef_FVO> category;
}
