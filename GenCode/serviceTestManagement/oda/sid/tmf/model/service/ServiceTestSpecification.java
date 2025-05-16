package oda.sid.tmf.model.service;

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
import oda.sid.tmf.model.service.EntitySpecification;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceTestSpecification extends EntitySpecification implements java.io.Serializable {
    private String description;
    @OneToMany
    @JoinColumn(name = "ServiceTestSpecification_id")
    @JsonManagedReference
    private List<ServiceTestSpecRelationship> serviceTestSpecRelationship;
    @OneToMany
    @JoinColumn(name = "ServiceTestSpecification_id")
    @JsonManagedReference
    private List<TestMeasureDefinition> testMeasureDefinition;
    @OneToMany
    @JoinColumn(name = "ServiceTestSpecification_id")
    @JsonManagedReference
    private List<ServiceSpecificationRef> relatedServiceSpecification;
}
