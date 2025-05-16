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
import oda.sid.tmf.model.resource.LogicalResourceSpecification;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceFunctionSpecification extends LogicalResourceSpecification implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ResourceFunctionSpecification_id")
    @JsonManagedReference
    private List<ConnectionPointSpecificationRef> connectionPointSpecification;
    @OneToMany
    @JoinColumn(name = "ResourceFunctionSpecification_id")
    @JsonManagedReference
    private List<ResourceGraphSpecification> connectivitySpecification;
}
