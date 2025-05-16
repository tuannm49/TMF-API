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
import oda.sid.vo.model.Entity_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceUsage_FVO extends Entity_FVO implements java.io.Serializable {
    private Boolean isBundle;
    private OffsetDateTime usageDate;
    @ManyToOne
    @JoinColumn(name = "usageSpecification_id")
    @JsonBackReference
    private ResourceUsageSpecificationRef_FVO usageSpecification;
    @ManyToOne
    @JoinColumn(name = "resource_id")
    @JsonBackReference
    private ResourceRef_FVO resource;
    private String description;
    @OneToMany
    @JoinColumn(name = "ResourceUsage_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ResourceUsage_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "ResourceUsage_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> usageCharacteristic;
    @OneToMany
    @JoinColumn(name = "ResourceUsage_FVO_id")
    @JsonManagedReference
    private List<ResourceUsageRef_FVO> bundledResourceUsage;
    private String usageType;
}
