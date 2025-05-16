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
import oda.sid.vo.model.Extensible_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharacteristicSpecification_FVO extends Extensible_FVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@valueSchemaLocation")
    private String valueSchemaLocation;
    private Boolean isUnique;
    private String description;
    private Integer maxCardinality;
    private Integer minCardinality;
    private String regex;
    private String valueType;
    @OneToMany
    @JoinColumn(name = "CharacteristicSpecification_FVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecificationRelationship_FVO> charSpecRelationship;
    @OneToMany
    @JoinColumn(name = "CharacteristicSpecification_FVO_id")
    @JsonManagedReference
    private List<CharacteristicValueSpecification_FVO> characteristicValueSpecification;
    private String name;
    private Boolean extensible;
    private Boolean configurable;
}
