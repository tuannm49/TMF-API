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
public class FeatureSpecification_MVO extends Extensible implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private Boolean isBundle;
    @Embedded
    private TimePeriod validFor;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "FeatureSpecification_MVO_FeatureSpecificationRelationship_MVO")
    private List<FeatureSpecificationRelationship_MVO> featureSpecRelationship;
    private Boolean isEnabled;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "FeatureSpecification_MVO_PolicyRef_MVO")
    private List<PolicyRef_MVO> policyConstraint;
    private String name;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String version;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "FeatureSpecification_MVO_CharacteristicSpecification_MVO")
    private List<CharacteristicSpecification_MVO> featureSpecCharacteristic;
}
