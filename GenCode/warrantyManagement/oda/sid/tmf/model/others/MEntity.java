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
public class MEntity implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private String context;
    private String description;
    private OffsetDateTime endDate;
    private Boolean isBundle;
    private Boolean isExternal;
    private String name;
    private OffsetDateTime startDate;
    private String status;
    private OffsetDateTime statusChangeDate;
    private String version;
    @OneToMany
    @JoinColumn(name = "MEntity_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @OneToMany
    @JoinColumn(name = "MEntity_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @OneToMany
    @JoinColumn(name = "MEntity_id")
    @JsonManagedReference
    private List<EntityRelationship> entityRelationship;
    @ManyToOne
    @JoinColumn(name = "entitySpecification_id")
    @JsonBackReference
    private EntitySpecificationRef entitySpecification;
    @OneToMany
    @JoinColumn(name = "MEntity_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "MEntity_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
