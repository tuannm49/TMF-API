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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Feature implements java.io.Serializable {
    @Id
    private String id;
    private Boolean isBundle;
    private Boolean isEnabled;
    private String name;
    @OneToMany
    @JoinColumn(name = "Feature_id")
    @JsonManagedReference
    private List<ConstraintRef> constraint;
    @OneToMany
    @JoinColumn(name = "Feature_id")
    @JsonManagedReference
    private List<Characteristic> featureCharacteristic;
    @OneToMany
    @JoinColumn(name = "Feature_id")
    @JsonManagedReference
    private List<FeatureRelationship> featureRelationship;
}
