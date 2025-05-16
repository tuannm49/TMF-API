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
import oda.sid.vo.model.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Document_FVO extends Entity implements java.io.Serializable {
    private String lifecycleState;
    @ManyToOne
    @JoinColumn(name = "documentSpecification_id")
    @JsonBackReference
    private DocumentSpecification_FVO documentSpecification;
    private String documentType;
    @ManyToOne
    @JoinColumn(name = "relatedEntity_id")
    @JsonBackReference
    private RelatedEntity_FVO relatedEntity;
    private String description;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "Document_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "Document_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> characteristic;
    @OneToMany
    @JoinColumn(name = "Document_FVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_FVO> attachment;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "Document_FVO_id")
    @JsonManagedReference
    private List<CategoryRef> category;
    @OneToMany
    @JoinColumn(name = "Document_FVO_id")
    @JsonManagedReference
    private List<DocumentRef> documentRelationship;
}
