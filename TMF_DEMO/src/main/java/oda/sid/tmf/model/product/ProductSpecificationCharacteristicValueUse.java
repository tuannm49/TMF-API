package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import oda.sid.tmf.model.base.EntityRef;
import oda.sid.tmf.model.base.Extensible;
import oda.sid.tmf.model.base.TimePeriod;
import oda.sid.tmf.model.common.CharacteristicValueSpecification;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductSpecificationCharacteristicValueUse extends Extensible implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    private Integer minCardinality;
    @OneToOne
    private EntityRef productSpecification;
    @Embedded
    private TimePeriod validFor;
    private String valueType;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "CharacteristicValueSpecification")
    private List<CharacteristicValueSpecification> productSpecCharacteristicValue;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private Integer maxCardinality;
}
