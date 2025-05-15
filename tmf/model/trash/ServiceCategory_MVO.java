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
public class ServiceCategory_MVO implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    private String lifecycleStatus;
    private Boolean isRoot;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "ServiceCategory_MVO_id")
    @JsonManagedReference
    private List<ServiceCandidateRef_MVO> serviceCandidate;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ServiceCategory_MVO_id")
    @JsonManagedReference
    private List<ServiceSpecificationRef_MVO> serviceSpecification;
    private String description;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "ServiceCategory_MVO_id")
    @JsonManagedReference
    private List<ServiceCategoryRef_MVO> category;
    private String version;
    private String parentId;
}
