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
public class ProductTest implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String description;
    @OneToMany
    @JoinColumn(name = "ProductTest_id")
    @JsonManagedReference
    private List<TestMeasure> testMeasure;
    private OffsetDateTime endDateTime;
    @OneToMany
    @JoinColumn(name = "ProductTest_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    @OneToMany
    @JoinColumn(name = "ProductTest_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @ManyToOne
    @JoinColumn(name = "testSpecification_id")
    @JsonBackReference
    private ProductTestSpecificationRef testSpecification;
    private String mode;
    private OffsetDateTime startDateTime;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "relatedProduct_id")
    @JsonBackReference
    private ProductRef relatedProduct;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductTest_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    private String href;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ExecutionStateType state;
    @OneToMany
    @JoinColumn(name = "ProductTest_id")
    @JsonManagedReference
    private List<IncidentRef> incidentRef;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
