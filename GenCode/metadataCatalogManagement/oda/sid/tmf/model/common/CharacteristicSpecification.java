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
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharacteristicSpecification implements java.io.Serializable {
    @Id
    private String id;
    private Boolean configurable;
    private String description;
    private Boolean extensible;
    private Boolean isUnique;
    private Integer maxCardinality;
    private Integer minCardinality;
    private String name;
    private String regex;
    private String valueType;
    @OneToMany
    @JoinColumn(name = "CharacteristicSpecification_id")
    @JsonManagedReference
    private List<CharacteristicSpecificationRelationship> charSpecRelationship;
    @OneToMany
    @JoinColumn(name = "CharacteristicSpecification_id")
    @JsonManagedReference
    private List<CharacteristicValueSpecification> characteristicValueSpecification;
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
    @JsonProperty("@valueSchemaLocation")
    private String valueSchemaLocation;
}
