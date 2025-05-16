package oda.sid.vo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductTest_FVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String description;
    @OneToMany
    @JoinColumn(name = "ProductTest_FVO_id")
    @JsonManagedReference
    private List<TestMeasure_FVO> testMeasure;
    private OffsetDateTime endDateTime;
    @OneToMany
    @JoinColumn(name = "ProductTest_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "ProductTest_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> characteristic;
    @ManyToOne
    @JoinColumn(name = "testSpecification_id")
    @JsonBackReference
    private ProductTestSpecificationRef_FVO testSpecification;
    private String mode;
    private OffsetDateTime startDateTime;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "relatedProduct_id")
    @JsonBackReference
    private ProductRef_FVO relatedProduct;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductTest_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    private String href;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ExecutionStateType state;
    @OneToMany
    @JoinColumn(name = "ProductTest_FVO_id")
    @JsonManagedReference
    private List<IncidentRef_FVO> incidentRef;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
