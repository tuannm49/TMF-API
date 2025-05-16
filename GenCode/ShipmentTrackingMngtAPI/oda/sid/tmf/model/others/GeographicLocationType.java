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
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicLocationType implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private String name;
    private String type;
    @OneToMany
    @JoinColumn(name = "GeographicLocationType_id")
    @JsonManagedReference
    private List<GeographicPointType> geographicPoint;
    private String accuracy;
    private String spatialRef;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
