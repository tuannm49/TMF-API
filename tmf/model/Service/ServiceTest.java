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
public class ServiceTest implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String description;
    @OneToMany
    @JoinColumn(name = "ServiceTest_id")
    @JsonManagedReference
    private List<TestMeasure> testMeasure;
    private OffsetDateTime endDateTime;
    @OneToMany
    @JoinColumn(name = "ServiceTest_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    @ManyToOne
    @JoinColumn(name = "relatedService_id")
    @JsonBackReference
    private ServiceRef relatedService;
    @OneToMany
    @JoinColumn(name = "ServiceTest_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @ManyToOne
    @JoinColumn(name = "testSpecification_id")
    @JsonBackReference
    private ServiceTestSpecificationRef testSpecification;
    private String mode;
    private OffsetDateTime startDateTime;
    @JsonProperty("@baseType")
    private String baseType;
    private String name;
    @OneToMany
    @JoinColumn(name = "ServiceTest_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    private String href;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ExecutionStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
