package oda.sid.tmf.model.product;

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
public class ProductSpecificationCharacteristicValueUse extends Extensible implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private Integer minCardinality;
    @OneToOne
    private EntityRef productSpecification;
    @Embedded
    private TimePeriod validFor;
    private String valueType;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecificationCharacteristicValueUse_CharacteristicValueSpecification")
    private List<CharacteristicValueSpecification> productSpecCharacteristicValue;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private Integer maxCardinality;
}
