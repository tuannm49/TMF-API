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
import oda.sid.vo.model.Entity_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceUsage_MVO extends Entity_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "usageSpecification_id")
    @JsonBackReference
    private ResourceUsageSpecificationRef_MVO usageSpecification;
    @ManyToOne
    @JoinColumn(name = "resource_id")
    @JsonBackReference
    private ResourceRef_MVO resource;
    private String description;
    @OneToMany
    @JoinColumn(name = "ResourceUsage_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ResourceUsage_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "ResourceUsage_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> usageCharacteristic;
    @OneToMany
    @JoinColumn(name = "ResourceUsage_MVO_id")
    @JsonManagedReference
    private List<ResourceUsageRef_MVO> bundledResourceUsage;
    private String usageType;
}
