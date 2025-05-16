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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Association_Update implements java.io.Serializable {
    private String description;
    private String lifecycleStatus;
    private String name;
    private String version;
    @ManyToOne
    @JoinColumn(name = "associationRole_id")
    @JsonBackReference
    private AssociationRole associationRole;
    @ManyToOne
    @JoinColumn(name = "associationSpec_id")
    @JsonBackReference
    private AssociationSpecificationRef associationSpec;
    @OneToMany
    @JoinColumn(name = "Association_Update_id")
    @JsonManagedReference
    private List<ConstraintRef> constraint;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
}
