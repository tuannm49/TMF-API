package oda.sid.tmf.model.others;

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
import java.util.List;
import oda.sid.tmf.model.others.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeatureSpecification extends Extensible implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "FeatureSpecification_id")
    @JsonManagedReference
    private List<FeatureSpecificationRelationship> featureSpecRelationship;
    private Boolean isEnabled;
    @OneToMany
    @JoinColumn(name = "FeatureSpecification_id")
    @JsonManagedReference
    private List<PolicyRef> policyConstraint;
    private String name;
    private String id;
    private String version;
    @OneToMany
    @JoinColumn(name = "FeatureSpecification_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> featureSpecCharacteristic;
}
