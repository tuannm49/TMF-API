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
import java.util.List;
import oda.sid.tmf.model.resource.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceRelationship extends Extensible implements java.io.Serializable {
    private String relationshipType;
    @OneToMany
    @JoinColumn(name = "ResourceRelationship_id")
    @JsonManagedReference
    private List<Characteristic> resourceRelationshipCharacteristic;
    @ManyToOne
    @JoinColumn(name = "resource_id")
    @JsonBackReference
    private ResourceRefOrValue resource;
}
