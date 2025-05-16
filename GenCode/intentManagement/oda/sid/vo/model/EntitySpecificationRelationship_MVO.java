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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntitySpecificationRelationship_MVO implements java.io.Serializable {
    private String name;
    private String role;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @ManyToOne
    @JoinColumn(name = "associationSpec_id")
    @JsonBackReference
    private AssociationSpecificationRef_MVO associationSpec;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String relationshipType;
}
