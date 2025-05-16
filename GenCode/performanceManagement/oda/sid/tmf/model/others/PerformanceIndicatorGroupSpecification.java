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
public class PerformanceIndicatorGroupSpecification implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    private String groupCategory;
    private String name;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "PerformanceIndicatorGroupSpecification_id")
    @JsonManagedReference
    private List<PerformanceIndicatorSpecificationRefOrValue> performanceIndicatorSpecification;
}
