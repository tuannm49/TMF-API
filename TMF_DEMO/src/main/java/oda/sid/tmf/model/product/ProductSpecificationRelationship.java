package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import oda.sid.tmf.model.base.AbstractEntity;
import oda.sid.tmf.model.base.TimePeriod;
import oda.sid.tmf.model.common.CharacteristicSpecification;

import java.util.List;
import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductSpecificationRelationship extends AbstractEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    private String relationshipType;
    @Embedded
    private TimePeriod validFor;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "CharacteristicSpecification")
    private List<CharacteristicSpecification> characteristic;
}
