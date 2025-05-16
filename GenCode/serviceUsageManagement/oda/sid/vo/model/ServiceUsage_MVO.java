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
public class ServiceUsage_MVO extends Entity_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "usageSpecification_id")
    @JsonBackReference
    private ServiceUsageSpecificationRef_MVO usageSpecification;
    @OneToMany
    @JoinColumn(name = "ServiceUsage_MVO_id")
    @JsonManagedReference
    private List<ResourceUsageRef_MVO> resourceUsage;
    @ManyToOne
    @JoinColumn(name = "service_id")
    @JsonBackReference
    private ServiceRef_MVO service;
    private String description;
    @OneToMany
    @JoinColumn(name = "ServiceUsage_MVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_MVO> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ServiceUsage_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "ServiceUsage_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> usageCharacteristic;
    private String usageType;
    @OneToMany
    @JoinColumn(name = "ServiceUsage_MVO_id")
    @JsonManagedReference
    private List<ServiceUsageRef_MVO> bundledServiceUsage;
}
