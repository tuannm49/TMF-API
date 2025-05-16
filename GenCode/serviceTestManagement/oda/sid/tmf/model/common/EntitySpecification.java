package oda.sid.tmf.model.common;

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
import oda.sid.tmf.model.common.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntitySpecification extends Entity implements java.io.Serializable {
    private Boolean isBundle;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @ManyToOne
    @JoinColumn(name = "targetEntitySchema_id")
    @JsonBackReference
    private TargetEntitySchema targetEntitySchema;
    private String description;
    @OneToMany
    @JoinColumn(name = "EntitySpecification_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> specCharacteristic;
    @OneToMany
    @JoinColumn(name = "EntitySpecification_id")
    @JsonManagedReference
    private List<EntitySpecificationRelationship> entitySpecRelationship;
    @OneToMany
    @JoinColumn(name = "EntitySpecification_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "EntitySpecification_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "EntitySpecification_id")
    @JsonManagedReference
    private List<ConstraintRef> constraint;
}
