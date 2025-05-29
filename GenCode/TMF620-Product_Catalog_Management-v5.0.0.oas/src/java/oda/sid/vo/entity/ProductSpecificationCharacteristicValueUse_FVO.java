package oda.sid.vo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.util.logging.Logger;
import oda.sid.tmf.entity.others.*;
import oda.sid.tmf.entity.common.*;
import oda.sid.tmf.entity.customer.*;
import oda.sid.tmf.entity.party.*;
import oda.sid.tmf.entity.product.*;
import oda.sid.tmf.entity.resource.*;
import oda.sid.tmf.entity.sale.*;
import oda.sid.tmf.entity.service.*;
import oda.sid.tmf.entity.base.*;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductSpecificationCharacteristicValueUse_FVO extends Extensible_FVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private Integer minCardinality;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ProductSpecificationRef_FVO productSpecification;
    @Embedded
    private TimePeriod validFor;
    private String valueType;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProductSpecificationCharacteristicValueUse_FVO_CharacteristicValueSpecification_FVO")
    private List<CharacteristicValueSpecification_FVO> productSpecCharacteristicValue;
    private Integer maxCardinality;
}
