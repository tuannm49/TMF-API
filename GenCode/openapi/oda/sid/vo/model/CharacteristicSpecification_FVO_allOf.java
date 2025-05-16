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
public class CharacteristicSpecification_FVO_allOf implements java.io.Serializable {
    @Id
    private String id;
    private String name;
    private String valueType;
    private String description;
    private Boolean configurable;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private Integer minCardinality;
    private Integer maxCardinality;
    private Boolean isUnique;
    private String regex;
    private Boolean extensible;
    @JsonProperty("@valueSchemaLocation")
    private String valueSchemaLocation;
    @OneToMany
    @JoinColumn(name = "CharacteristicSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<CharacteristicSpecificationRelationship_FVO> charSpecRelationship;
    @OneToMany
    @JoinColumn(name = "CharacteristicSpecification_FVO_allOf_id")
    @JsonManagedReference
    private List<CharacteristicValueSpecification_FVO> characteristicValueSpecification;
}
