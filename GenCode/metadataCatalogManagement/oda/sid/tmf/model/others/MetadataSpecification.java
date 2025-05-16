package oda.sid.tmf.model.others;

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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetadataSpecification implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private String description;
    private Boolean isComposed;
    private OffsetDateTime lastUpdate;
    private String lifecycleStatus;
    private String name;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_id")
    @JsonManagedReference
    private List<CompositeMetadataSpecification> compositeMetadataSpecification;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_id")
    @JsonManagedReference
    private List<EntitySpecificationRelationship> entitySpecRelationship;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> metadataSpecCharacteristic;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_id")
    @JsonManagedReference
    private List<PolicySpecificationRef> policySpecificationRef;
    @OneToMany
    @JoinColumn(name = "MetadataSpecification_id")
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
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
