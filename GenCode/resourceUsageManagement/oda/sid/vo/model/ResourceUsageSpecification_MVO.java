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
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.vo.model.Entity_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceUsageSpecification_MVO extends Entity_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "ResourceUsageSpecification_MVO_id")
    @JsonManagedReference
    private List<ResourceUsageSpecificationRef_MVO> bundledResourceUsageSpecification;
    private String lifecycleStatus;
    @OneToMany
    @JoinColumn(name = "ResourceUsageSpecification_MVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_MVO> attachment;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "ResourceUsageSpecification_MVO_id")
    @JsonManagedReference
    private List<ResourceSpecificationRef_MVO> resourceSpecification;
    @OneToMany
    @JoinColumn(name = "ResourceUsageSpecification_MVO_id")
    @JsonManagedReference
    private List<ResourceUsageSpecRelationship_MVO> resourceUsageSpecRelationship;
    private String description;
    @OneToMany
    @JoinColumn(name = "ResourceUsageSpecification_MVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_MVO> specCharacteristic;
    private String version;
}
