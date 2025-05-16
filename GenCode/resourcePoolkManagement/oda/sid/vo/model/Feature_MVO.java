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
import java.util.List;
import oda.sid.vo.model.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Feature_MVO extends Extensible implements java.io.Serializable {
    private Boolean isBundle;
    private Boolean isEnabled;
    @OneToMany
    @JoinColumn(name = "Feature_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> featureCharacteristic;
    @OneToMany
    @JoinColumn(name = "Feature_MVO_id")
    @JsonManagedReference
    private List<PolicyRef_MVO> policyConstraint;
    private String name;
    private String id;
    @OneToMany
    @JoinColumn(name = "Feature_MVO_id")
    @JsonManagedReference
    private List<FeatureRelationship_MVO> featureRelationship;
}
