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
public class FeatureSpecification_FVO extends Extensible_FVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private Boolean isBundle;
    @Embedded
    private TimePeriod validFor;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "FeatureSpecification_FVO_FeatureSpecificationRelationship_FVO")
    private List<FeatureSpecificationRelationship_FVO> featureSpecRelationship;
    private Boolean isEnabled;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "FeatureSpecification_FVO_PolicyRef_FVO")
    private List<PolicyRef_FVO> policyConstraint;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "FeatureSpecification_FVO_CharacteristicSpecification_FVO")
    private List<CharacteristicSpecification_FVO> featureSpecCharacteristic;
}
