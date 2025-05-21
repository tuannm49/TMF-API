package oda.sid.vo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import java.util.List;
import java.util.Date;
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
public class ProductSpecificationCharacteristicValueUse_FVO extends Extensible_FVO implements java.io.Serializable {
    private Integer minCardinality;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="id", column=@Column(name = "productSpecification_id")),
            @AttributeOverride(name="name", column=@Column(name = "productSpecification_name")),
            @AttributeOverride(name="version", column=@Column(name = "productSpecification_version")),
            @AttributeOverride(name="href", column=@Column(name = "productSpecification_href")),
            @AttributeOverride(name="type", column=@Column(name = "productSpecification_type")),
            @AttributeOverride(name="baseType", column=@Column(name = "productSpecification_baseType")),
            @AttributeOverride(name="referredType", column=@Column(name = "productSpecification_referredType")),
            @AttributeOverride(name="schemaLocation", column=@Column(name = "productSpecification_schemaLocation"))
    })
    private ProductSpecificationRef_FVO productSpecification;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="type", column=@Column(name = "target_type")),@AttributeOverride(name="schemaLocation", column=@Column(name = "target_schemaLocation"))})
    private TimePeriod validFor;
    private String valueType;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ProductSpecificationCharacteristicValueUse_FVO_id")
    private List<CharacteristicValueSpecification_FVO> productSpecCharacteristicValue;
    private Integer maxCardinality;
}
