package oda.sid.tmf.model.resource;

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
import oda.sid.tmf.model.resource.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceSpecificationRelationship extends Extensible implements java.io.Serializable {
    private String role;
    private String relationshipType;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String name;
    private String id;
    private String href;
    private Integer defaultQuantity;
    private Integer minimumQuantity;
    @OneToMany
    @JoinColumn(name = "ResourceSpecificationRelationship_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> characteristic;
    private Integer maximumQuantity;
}
