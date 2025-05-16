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
import oda.sid.vo.model.LogicalResource_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourcePool_FVO extends LogicalResource_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ResourcePool_FVO_id")
    @JsonManagedReference
    private List<ResourceRef_FVO> pooledResource;
    @ManyToOne
    @JoinColumn(name = "pooledResourceSpecification_id")
    @JsonBackReference
    private ResourceSpecificationRef_FVO pooledResourceSpecification;
    @OneToMany
    @JoinColumn(name = "ResourcePool_FVO_id")
    @JsonManagedReference
    private List<Capacity_FVO> capacity;
}
