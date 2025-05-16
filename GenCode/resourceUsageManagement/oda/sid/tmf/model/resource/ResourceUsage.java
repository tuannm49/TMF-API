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
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.tmf.model.resource.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceUsage extends Entity implements java.io.Serializable {
    private Boolean isBundle;
    private OffsetDateTime usageDate;
    @ManyToOne
    @JoinColumn(name = "usageSpecification_id")
    @JsonBackReference
    private ResourceUsageSpecificationRef usageSpecification;
    @ManyToOne
    @JoinColumn(name = "resource_id")
    @JsonBackReference
    private ResourceRef resource;
    private String description;
    @OneToMany
    @JoinColumn(name = "ResourceUsage_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalIdentifier;
    @OneToMany
    @JoinColumn(name = "ResourceUsage_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    @OneToMany
    @JoinColumn(name = "ResourceUsage_id")
    @JsonManagedReference
    private List<Characteristic> usageCharacteristic;
    @OneToMany
    @JoinColumn(name = "ResourceUsage_id")
    @JsonManagedReference
    private List<ResourceUsageRef> bundledResourceUsage;
    private String usageType;
}
