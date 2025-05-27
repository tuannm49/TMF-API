package oda.sid.tmf.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import oda.sid.tmf.model.base.*;
import oda.sid.tmf.model.product.Catalog;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharacteristicSpecification extends Extensible implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    @Embedded
    private TimePeriod validFor;
    @JsonProperty("@valueSchemaLocation")
    private String valueSchemaLocation;
    private Boolean isUnique;
    private String description;
    private Integer maxCardinality;
    private Integer minCardinality;
    private String regex;
    private String valueType;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "CharSpec_charSpecRel")
    private List<CharacteristicSpecificationRelationship> charSpecRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "CharSpec_characteristicValSpec")
    private List<CharacteristicValueSpecification> characteristicValueSpecification;
    private String name;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private Boolean extensible;
    private Boolean configurable;
}
