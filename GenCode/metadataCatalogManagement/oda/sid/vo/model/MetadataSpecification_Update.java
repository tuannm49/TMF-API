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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetadataSpecification_Update implements java.io.Serializable {
    private String description;
    private Boolean isComposed;
    private String lifecycleStatus;
    private String name;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Update_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Update_id")
    @JsonManagedReference
    private List<CompositeMetadataSpecification> compositeMetadataSpecification;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Update_id")
    @JsonManagedReference
    private List<EntitySpecificationRelationship> entitySpecRelationship;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Update_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> metadataSpecCharacteristic;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Update_id")
    @JsonManagedReference
    private List<PolicySpecificationRef> policySpecificationRef;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_Update_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "targetEntitySchema_id")
    @JsonBackReference
    private TargetEntitySchema targetEntitySchema;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
}
