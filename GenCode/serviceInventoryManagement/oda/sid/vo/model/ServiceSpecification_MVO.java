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
import oda.sid.vo.model.EntitySpecification_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceSpecification_MVO extends EntitySpecification_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ServiceSpecification_MVO_id")
    @JsonManagedReference
    private List<ResourceSpecificationRef_MVO> resourceSpecification;
    @ManyToOne
    @JoinColumn(name = "intentSpecification_id")
    @JsonBackReference
    private IntentSpecificationRef_MVO intentSpecification;
    @OneToMany
    @JoinColumn(name = "ServiceSpecification_MVO_id")
    @JsonManagedReference
    private List<FeatureSpecification_MVO> featureSpecification;
    @OneToMany
    @JoinColumn(name = "ServiceSpecification_MVO_id")
    @JsonManagedReference
    private List<ServiceLevelSpecificationRef_MVO> serviceLevelSpecification;
    @OneToMany
    @JoinColumn(name = "ServiceSpecification_MVO_id")
    @JsonManagedReference
    private List<EntityRelationship_MVO> serviceSpecRelationship;
}
