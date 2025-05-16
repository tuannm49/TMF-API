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
public class MetadataCatalogItem_Update implements java.io.Serializable {
    private String description;
    private String lifecycleStatus;
    private String name;
    @OneToMany
    @JoinColumn(name = "MetadataCatalogItem_Update_id")
    @JsonManagedReference
    private List<MetadataCategoryRef> category;
    @ManyToOne
    @JoinColumn(name = "specification_id")
    @JsonBackReference
    private MetadataSpecificationRef specification;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
}
