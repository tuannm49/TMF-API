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
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.tmf.model.service.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceUsage extends Entity implements java.io.Serializable {
    private Boolean isBundle;
    private OffsetDateTime usageDate;
    @ManyToOne
    @JoinColumn(name = "usageSpecification_id")
    @JsonBackReference
    private ServiceUsageSpecificationRef usageSpecification;
    @OneToMany
    @JoinColumn(name = "ServiceUsage_id")
    @JsonManagedReference
    private List<ResourceUsageRef> resourceUsage;
    @ManyToOne
    @JoinColumn(name = "service_id")
    @JsonBackReference
    private ServiceRef service;
    private String description;
    @OneToMany
    @JoinColumn(name = "ServiceUsage_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ServiceUsage_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    @OneToMany
    @JoinColumn(name = "ServiceUsage_id")
    @JsonManagedReference
    private List<Characteristic> usageCharacteristic;
    private String usageType;
    @OneToMany
    @JoinColumn(name = "ServiceUsage_id")
    @JsonManagedReference
    private List<ServiceUsageRef> bundledServiceUsage;
}
