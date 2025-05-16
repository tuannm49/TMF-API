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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceOrder_Create implements java.io.Serializable {
    private String category;
    private String description;
    private String externalId;
    private String name;
    private String orderType;
    private Integer priority;
    private OffsetDateTime requestedCompletionDate;
    private OffsetDateTime requestedStartDate;
    private OffsetDateTime startDate;
    @OneToMany
    @JoinColumn(name = "ResourceOrder_Create_id")
    @JsonManagedReference
    private List<ExternalReference> externalReference;
    @OneToMany
    @JoinColumn(name = "ResourceOrder_Create_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "ResourceOrder_Create_id")
    @JsonManagedReference
    private List<ResourceOrderItem> orderItem;
    @OneToMany
    @JoinColumn(name = "ResourceOrder_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
