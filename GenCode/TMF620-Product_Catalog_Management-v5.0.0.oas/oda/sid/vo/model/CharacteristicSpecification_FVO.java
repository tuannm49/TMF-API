package oda.sid.vo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.util.logging.Logger;
import oda.sid.tmf.model.others.*;
import oda.sid.tmf.model.common.*;
import oda.sid.tmf.model.customer.*;
import oda.sid.tmf.model.party.*;
import oda.sid.tmf.model.product.*;
import oda.sid.tmf.model.resource.*;
import oda.sid.tmf.model.sale.*;
import oda.sid.tmf.model.service.*;
import oda.sid.tmf.model.base.*;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharacteristicSpecification_FVO extends Extensible_FVO implements java.io.Serializable {
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
    @JoinTable(name = "CharacteristicSpecificationRelationship_FVO")
    private List<CharacteristicSpecificationRelationship_FVO> charSpecRelationship;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "CharacteristicValueSpecification_FVO")
    private List<CharacteristicValueSpecification_FVO> characteristicValueSpecification;
    private Boolean extensible;
    private Boolean configurable;
}
