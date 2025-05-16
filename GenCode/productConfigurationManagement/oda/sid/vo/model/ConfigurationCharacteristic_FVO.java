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
public class ConfigurationCharacteristic_FVO extends Extensible_FVO implements java.io.Serializable {
    private Integer minCardinality;
    private String regex;
    @OneToMany
    @JoinColumn(name = "ConfigurationCharacteristic_FVO_id")
    @JsonManagedReference
    private List<ConfigurationCharacteristicValue_FVO> configurationCharacteristicValue;
    private Boolean isConfigurable;
    private String valueType;
    private String name;
    private String description;
    private String id;
    private Integer maxCardinality;
    @OneToMany
    @JoinColumn(name = "ConfigurationCharacteristic_FVO_id")
    @JsonManagedReference
    private List<ConfigurationCharacteristicRelationship_FVO> configurationCharacteristicRelationship;
}
