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
public class EntityCategory_Create implements java.io.Serializable {
    private String description;
    private Boolean isRoot;
    private OffsetDateTime lastUpdate;
    private String lifecycleStatus;
    private String name;
    private String parentId;
    private String version;
    @OneToMany
    @JoinColumn(name = "EntityCategory_Create_id")
    @JsonManagedReference
    private List<EntityCategoryRef> childCategory;
    @OneToMany
    @JoinColumn(name = "EntityCategory_Create_id")
    @JsonManagedReference
    private List<EntityCatalogItemRef> entityCatalogItem;
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
