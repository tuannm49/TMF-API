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
public class ServiceTest_MVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String description;
    @OneToMany
    @JoinColumn(name = "ServiceTest_MVO_id")
    @JsonManagedReference
    private List<TestMeasure_MVO> testMeasure;
    private OffsetDateTime endDateTime;
    @OneToMany
    @JoinColumn(name = "ServiceTest_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    @ManyToOne
    @JoinColumn(name = "relatedService_id")
    @JsonBackReference
    private ServiceRef_MVO relatedService;
    @OneToMany
    @JoinColumn(name = "ServiceTest_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> characteristic;
    @ManyToOne
    @JoinColumn(name = "testSpecification_id")
    @JsonBackReference
    private ServiceTestSpecificationRef_MVO testSpecification;
    private String mode;
    private OffsetDateTime startDateTime;
    private String name;
    @OneToMany
    @JoinColumn(name = "ServiceTest_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ExecutionStateType state;
}
